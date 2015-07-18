package com.xfinity.controller;

import java.sql.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.controls.DHXAgendaView;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.xfinity.event.manager.EventManager;
import com.xfinity.model.Event;
import com.xfinity.model.User;
import com.xfinity.model.UserPreference;
import com.xfinity.service.EventService;
import com.xfinity.service.UserService;

@Controller
public class HelloController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/")
	public String homeS(Model model){
		model.addAttribute("greeting","HELLO WORLDss");	
		return "hello";
	}	
	
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model){
		model.addAttribute("greeting","HELLO WORLDss");
		
		Event evt = new Event();
		evt.setStart_date(new Date(115,5,24));
		evt.setEnd_date(new Date(115,5,25));
		evt.setText("Test Event");
		eventService.save(evt);		
		return "hello";
	}	
	
	@RequestMapping("/my/planner")
    public ModelAndView planner(HttpServletRequest request) throws Exception {	
		
			User user = getUser();
			UserPreference userPref = user.getUserPreference();
            DHXPlanner p = new DHXPlanner("../codebase_common/", DHXSkin.valueOf(userPref.getSkin()));
            
            String params = "";
            
            String recurringFilter = request.getParameter("hideRecur");
            if(recurringFilter != null && recurringFilter.equals("yes")){
            	params += "hideRecur=yes&";
            }
            //p.setInitialDate(2013, 1, 2);
            p.extensions.add(DHXExtension.RECURRING);
            //p.config.setScrollHour(8);
        	p.config.setFullDay(true);
        	p.config.setMultiDay(true);
        	//p.views.add(new DHXAgendaView());
        	//p.extensions.add(DHXExtension.WEEK_AGENDA);
        	p.calendars.attachMiniCalendar();
        	p.extensions.add(DHXExtension.TOOLTIP);
        	//p.setInitialView("month");
        	p.config.setDetailsOnCreate(true);
        	p.config.setDetailsOnDblClick(true);
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
        	
            p.load("../my/events?"+params, DHXDataFormat.JSON);
            p.data.dataprocessor.setURL("../my/events");
            ModelAndView mnv = new ModelAndView("article");
            mnv.addObject("body", p.render());
            return mnv;
    }

    private User getUser() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();		
	    User user = userService.getUser(username);
	    return user;
	}


	@RequestMapping("/my/events")
    @ResponseBody public String events(HttpServletRequest request) {
            //EventsManager evs = new EventsManager(request);
            //return evs.run();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();		
	    User user = userService.getUser(username);	    
	    
	    String recurringFilter = request.getParameter("hideRecur");
	    
	    HashMap<String, String> options = new HashMap<String,String>();
	    
	    if(recurringFilter != null && recurringFilter.equals("yes")){
	    	options.put("hideRecur", "yes");
	    }
	    
    	EventManager evs = new EventManager(request,eventService,userService,user,options);
    	return evs.run();
            //CustomEventsManager evs = new CustomEventsManager(request);
            //return evs.run();
    }
    
    @RequestMapping("/my/agenda")
    public ModelAndView scheduler_05(HttpServletRequest request) throws Exception {
    	DHXPlanner p = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
        //p.setInitialDate(2013, 1, 2);
        p.extensions.add(DHXExtension.RECURRING);
        //p.config.setScrollHour(8);
    	p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	p.views.clear();
    	p.views.add(new DHXAgendaView());
    	p.setInitialView("agenda");
    	//p.extensions.add(DHXExtension.WEEK_AGENDA);
    	//p.calendars.attachMiniCalendar();
    	
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
    	
        p.load("../my/events", DHXDataFormat.JSON);
        p.data.dataprocessor.setURL("../my/events");
        ModelAndView mnv = new ModelAndView("article");
        mnv.addObject("body", p.render());
        return mnv;
    }
	
}