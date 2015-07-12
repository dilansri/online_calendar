package com.xfinity.controller;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.xfinity.event.manager.EventManager;
import com.xfinity.model.User;
import com.xfinity.service.CalendarService;
import com.xfinity.service.EventService;
import com.xfinity.service.UserService;

@Controller
public class CalendarController {
	@Autowired
	UserService userService;
	
	@Autowired
	CalendarService calendarService;
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value="/my/shareCalendar",method=RequestMethod.POST)
	public ModelAndView shareUserCalendar(WebRequest request, Model model){
		
		String sharedWithUser= request.getParameter("shared_with");
		User user = userService.getUser(sharedWithUser);
		if(user == null) {
			return new ModelAndView("sharingFailure");
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sharedByUser = auth.getName(); //get logged in username
	    
	    try{
	    	calendarService.shareCalendar(sharedByUser, sharedWithUser);
	    }catch(PersistenceException cve){
	    	return new ModelAndView("sharingFailure");
	    }
		
		return new ModelAndView("registerSuccess");
	}
	
	@RequestMapping(value="/my/viewCalendar",method=RequestMethod.GET)
	public ModelAndView viewUserCalendar(WebRequest request, Model model) throws Exception{
		String user= request.getParameter("user");
		
		//TODO Check for validity
		
		//User sharedUser = userService.getUser(user);
		
		DHXPlanner p = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
        
        //p.extensions.add(DHXExtension.RECURRING);        
    	p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	p.config.setShowLoading(true);
    	p.config.setReadonly(true);
    	p.config.setReadonlyForm(true);
    	
    	p.extensions.add(DHXExtension.TOOLTIP);
        
    	
    	//p.toPDF();
    	
        p.load("../sharedCalendar.html?user="+user, DHXDataFormat.JSON);
        //p.data.dataprocessor.setURL("../events.html");
        ModelAndView mnv = new ModelAndView("article");
        mnv.addObject("body", p.render());
        return mnv;		
		
	}
	
	@RequestMapping("/sharedCalendar")
    @ResponseBody public String events(HttpServletRequest request) {           
		
		String user= request.getParameter("user");    	
    	
	    User calendarUser = userService.getUser(user);
	    
    	EventManager evs = new EventManager(request,eventService,userService,calendarUser);
    	return evs.run();
            
    }
}
