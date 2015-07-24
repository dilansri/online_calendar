package com.xfinity.controller;

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
import com.dhtmlx.planner.controls.DHXLightboxText;
import com.dhtmlx.planner.controls.DHXMapView;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.xfinity.event.manager.EventManager;
import com.xfinity.model.User;
import com.xfinity.model.UserPreference;
import com.xfinity.service.EventService;
import com.xfinity.service.UserService;

@Controller
public class EventController {
	
	/**
	 * Injecting required services
	 */
	@Autowired
	private EventService eventService;
	
	@Autowired
	UserService userService;
	
	
	/**
	 * Routings for main calendar Pages
	 */
			
	
	@RequestMapping(value="/")
	public String home(Model model){
		return "hello";
	}	
	
	@RequestMapping(value="/404")
	public String error404Page(){
		return "403";
	}
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model){			
		return "test";
	}	
	
	/**
	 * Personal Planner Handling
	 */
	@RequestMapping("/my/planner")
    public ModelAndView planner(HttpServletRequest request) throws Exception {	
			
		/**
		 * Check for authentication of the user
		 */
			if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
				return new ModelAndView("redirect:/login");
			}
		/**
		 * Initializing the Planner with user settings
		 */
			User user = getUser();
			UserPreference userPref = user.getUserPreference();
            DHXPlanner p = new DHXPlanner("../codebase_common/", DHXSkin.valueOf(userPref.getSkin()));
            
            String params = "";
        /**
         * Hiding recurring events logic    
         */
            String recurringFilter = request.getParameter("hideRecur");
            if(recurringFilter != null && recurringFilter.equals("yes")){
            	params += "hideRecur=yes&";
            }
            
            /**
             * Configurations of the planner
             */
            p.extensions.add(DHXExtension.RECURRING);
        	p.config.setFullDay(true);
        	p.config.setMultiDay(true);
        	p.toPDF();
        	p.calendars.attachMiniCalendar();
        	p.extensions.add(DHXExtension.TOOLTIP);
        	p.config.setDetailsOnCreate(true);
        	p.config.setDetailsOnDblClick(true);
        	
        	
        	/**
        	 * Showing Map logic
        	 */
        	
        	String enableMap = request.getParameter("map");
            if(enableMap != null && enableMap.equals("yes")){
            	
            	p.views.clear();
            	
            	DHXMapView map = new DHXMapView();
            	p.views.add(map);
            	p.setInitialView("map");
            	
            	
            	DHXLightboxText loc = new DHXLightboxText("event_location", "Location");
            	loc.setHeight(40);
            	p.lightbox.add(loc);
            	
            	params += "showMap=yes&";
            }
        	
        	/**
        	 * Responding to the request with View model        	
        	 */
        	
            p.load("../my/events?"+params, DHXDataFormat.JSON);
            p.data.dataprocessor.setURL("../my/events");
            ModelAndView mnv = new ModelAndView("planner");
            mnv.addObject("body", p.render());
            return mnv;
    }
	
	
/**
 *  Helper method to get the logged in user
 * 
 */
    private User getUser() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();		
	    User user = userService.getUser(username);
	    return user;
	}

    
/**
 * Communication with the EventManager
 * 
 */

	@RequestMapping("/my/events")
    @ResponseBody public String events(HttpServletRequest request) {
        
		if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			return "redirect:/login";
		}
	
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();		
	    User user = userService.getUser(username);	    
	    
	    String recurringFilter = request.getParameter("hideRecur");
	    String showMap = request.getParameter("showMap");
	    
	    HashMap<String, String> options = new HashMap<String,String>();
	    
	    if(recurringFilter != null && recurringFilter.equals("yes")){
	    	options.put("hideRecur", "yes");
	    }
	    if(showMap != null && showMap.equals("yes")){
	    	options.put("showMap", "yes");
	    }
	    
	    
	    
	    
    	EventManager evs = new EventManager(request,eventService,userService,user,options);
    	return evs.run();
    }
/**
 * Handling Agenda View's Logic    
 * 
 */
    @RequestMapping("/my/agenda")
    public ModelAndView agenda(HttpServletRequest request) throws Exception {
    	
    	/**
    	 * Authentication check
    	 */
    	if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			return new ModelAndView("redirect:/login");
		}
	/**
	 * Retreving logged in user and initializing the agenda
	 */
    	User user = getUser();
		UserPreference userPref = user.getUserPreference();
    	DHXPlanner p = new DHXPlanner("../codebase/", DHXSkin.valueOf(userPref.getSkin()));
        
    	/**
    	 * Agenda View's configuration
    	 */
        p.extensions.add(DHXExtension.RECURRING);        
    	p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	p.toPDF();
    	p.views.clear();
    	p.views.add(new DHXAgendaView());
    	p.setInitialView("agenda");
    	
    	
    	    	
    	/**
    	 * Retreving Events for the Agenda
    	 */
        p.load("../my/events", DHXDataFormat.JSON);
        p.data.dataprocessor.setURL("../my/events");
        ModelAndView mnv = new ModelAndView("agenda");
        mnv.addObject("body", p.render());
        return mnv;
    }
}
