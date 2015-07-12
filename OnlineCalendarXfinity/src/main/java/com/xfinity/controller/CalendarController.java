package com.xfinity.controller;

import java.util.List;

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
import com.xfinity.event.manager.SharedEventManager;
import com.xfinity.event.manager.TeamEventManager;
import com.xfinity.model.User;
import com.xfinity.service.CalendarService;
import com.xfinity.service.EventService;
import com.xfinity.service.TeamEventService;
import com.xfinity.service.UserService;

@Controller
public class CalendarController {
	@Autowired
	UserService userService;
	
	@Autowired
	CalendarService calendarService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	TeamEventService teamEventService;
	
	@RequestMapping(value="/my/share")
	public ModelAndView share(HttpServletRequest request){
		
		ModelAndView mnv = new ModelAndView("shareCalendar");
        
		List<String> sharedWithMeUsers = calendarService.getSharedCalendarsWithMe();
		List<String> sharedByMeUsers = calendarService.getSharedCalendarsByMe();
		
		mnv.addObject("sharedWithMeUsers", sharedWithMeUsers);
		mnv.addObject("sharedByMeUsers", sharedByMeUsers);
        return mnv;
	}	
	
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
		if(!calendarService.isCalendarShared(user)){
			return new ModelAndView("sharingFailure");
		}
		
		//User sharedUser = userService.getUser(user);
		
		DHXPlanner p = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
        
        //p.extensions.add(DHXExtension.RECURRING);        
    	p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	p.config.setShowLoading(true);
    	//p.config.setReadonly(true);
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
    @ResponseBody public String sharedCalendar(HttpServletRequest request) {           
		
		String user= request.getParameter("user");    	
    	
	    User calendarUser = userService.getUser(user);
	    
	    SharedEventManager evs = new SharedEventManager(request,eventService,userService,calendarUser);
    	return evs.run();
            
    }
	
	@RequestMapping("/my/teamCalendar.html")
	public ModelAndView teamCalendar(WebRequest request, Model model) throws Exception{ 
		
		DHXPlanner p = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
        //p.setInitialDate(2013, 1, 2);
        //p.extensions.add(DHXExtension.RECURRING);
        //p.config.setScrollHour(8);
    	p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	//p.views.add(new DHXAgendaView());
    	//p.extensions.add(DHXExtension.WEEK_AGENDA);
    	p.calendars.attachMiniCalendar();
    	p.extensions.add(DHXExtension.TOOLTIP);
    	
    	/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();*/
	    
    	//p.templates.setEventText(username+": {text}");
        //p.setWidth(900);
    	
    	/*
    	DHXBlockTime block = new DHXBlockTime();
    	block.setDay(DHXDayOfWeek.SUNDAY);
    	p.timespans.add(block);
    	
    	DHXBlockTime block2 = new DHXBlockTime();
    	block2.setDay(DHXDayOfWeek.SATURDAY);
    	p.timespans.add(block2);
    	
    	*/
    	
    	p.toPDF();
    	
        p.load("../teamEvents.html", DHXDataFormat.JSON);
        p.data.dataprocessor.setURL("../teamEvents.html");
		
		ModelAndView mnv = new ModelAndView("article");
		mnv.addObject("body", p.render());
        return mnv;	
	}
	
	@RequestMapping("/teamEvents")
    @ResponseBody public String teamEvents(HttpServletRequest request) { 
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		
	    User user = userService.getUser(username);
	    
    	TeamEventManager evs = new TeamEventManager(request,teamEventService,user);
    	return evs.run();
            
    }
}
