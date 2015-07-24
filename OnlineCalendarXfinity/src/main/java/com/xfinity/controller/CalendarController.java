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
import com.dhtmlx.planner.api.DHXBlockTime;
import com.dhtmlx.planner.api.DHXTimeSpan.DHXDayOfWeek;
import com.dhtmlx.planner.api.DHXZone;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.xfinity.event.manager.DoctorAppointmentManager;
import com.xfinity.event.manager.TeamEventManager;
import com.xfinity.model.User;
import com.xfinity.model.UserPreference;
import com.xfinity.service.CalendarService;
import com.xfinity.service.DoctorAppointmentService;
import com.xfinity.service.EventService;
import com.xfinity.service.TeamEventService;
import com.xfinity.service.UserService;

@Controller
public class CalendarController {
	/**
	 * Injecting required dependencies
	 */
	
	@Autowired
	UserService userService;
	
	@Autowired
	CalendarService calendarService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	TeamEventService teamEventService;
	
	@Autowired
	DoctorAppointmentService doctorAppointmentService;
	
	/**
	 * Mapping calendar based requests to methods
	 */
	
	
	/**
	 * Sharing calendar feature
	 */
	@RequestMapping(value="/my/share")
	public ModelAndView share(HttpServletRequest request){
		
		/**
		 * Initializing the View model of sharing calendar
		 */
		ModelAndView mnv = new ModelAndView("shareCalendar");        
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sharedByUser = auth.getName();
		
	    
	    /**
	     * Handling user's sharing calendar with specific user process
	     */
		if(request.getMethod().equals("POST")){
			String sharedWithUser= request.getParameter("shared_with");
			User user = userService.getUser(sharedWithUser);
			
			/**
			 * Handling errors when sharing user
			 */
			if(user == null) {
				mnv.addObject("error","User not found.");
				return mnv;
			}
			
			if(sharedWithUser.equals(sharedByUser)){
				mnv.addObject("error","You can't share your calender to yourself.");
				return mnv;
			}
		    
			/**
			 * Calling calendar service to persist the sharing
			 */
		    try{
		    	calendarService.shareCalendar(sharedByUser, sharedWithUser);
		    }catch(PersistenceException cve){
		    	mnv.addObject("error","Something went wrong.");
		    	return mnv;
		    }		    
		    mnv.addObject("success","Your calendar has been successfully shared with "+sharedWithUser);
		    
		}
		/**
		 * Revoking access to calendar for a specific user
		 */
		else if(request.getMethod().equals("GET") && request.getParameter("del") != null){
			String sharedWithUser = request.getParameter("del");
			User user = userService.getUser(sharedWithUser);
			if(user == null) {
				mnv.addObject("error","Invalid delete operation.");
				return mnv;
			}
			
			if(calendarService.revokeCalendarSharing(sharedByUser, sharedWithUser)){
				mnv.addObject("success"," "+sharedWithUser+ " is removed from your shared list.");
				
			}else{
				mnv.addObject("error","No sharing found");
				return mnv;
			}			
		}
		
		/**
		 * Displaying shared calendars list and user who can see logged in users calendar
		 */
		
		List<String> sharedWithMeUsers = calendarService.getSharedCalendarsWithMe();
		List<String> sharedByMeUsers = calendarService.getSharedCalendarsByMe();		
		mnv.addObject("sharedWithMeUsers", sharedWithMeUsers);
		mnv.addObject("sharedByMeUsers", sharedByMeUsers);
		
        return mnv;
	}	
	
		
	private User getUser() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();		
	    User user = userService.getUser(username);
	    return user;
	}
	
	/**
	 * Managing a user viewing someone else calendar
	 */
	
	@RequestMapping(value="/my/viewCalendar",method=RequestMethod.GET)
	public ModelAndView viewUserCalendar(WebRequest request, Model model) throws Exception{
		String user= request.getParameter("user");
		
		
		if(!calendarService.isCalendarShared(user)){
			return new ModelAndView("sharingFailure");
		}
		
		User loggedUser = getUser();
		UserPreference userPref = loggedUser.getUserPreference();
    	
		DHXPlanner p = new DHXPlanner("../codebase/", DHXSkin.valueOf(userPref.getSkin()));
               
    	p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	p.config.setShowLoading(true);
    	p.config.setReadonlyForm(true);    	
    	p.extensions.add(DHXExtension.TOOLTIP);
        
    	
    	/**
    	 * Loading other user's events to the calendar
    	 */
        p.load("../sharedCalendar.html?user="+user, DHXDataFormat.JSON);
        
        /**
         * Generating content of the calendar
         */
        ModelAndView mnv = new ModelAndView("viewCalendar");
        mnv.addObject("user",user);
        mnv.addObject("body", p.render());
        return mnv;		
		
	}
	
	/**
	 * Team Calendar feature
	 */
	
	@RequestMapping("/my/teamCalendar")
	public ModelAndView teamCalendar(WebRequest request, Model model) throws Exception{ 
		
		/**
		 * Check for authentication of the user
		 */
		if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			return new ModelAndView("redirect:/login");
		}
		
		/**
		 * Settingup user's view to the Team Calendar
		 */
		User user = getUser();
		UserPreference userPref = user.getUserPreference();
		DHXPlanner p = new DHXPlanner("../codebase_common/", DHXSkin.valueOf(userPref.getSkin()));
        
    	
    	p.calendars.attachMiniCalendar();
    	p.extensions.add(DHXExtension.TOOLTIP);
    	p.config.setFullDay(true);
    	p.toPDF();
    	p.config.setMultiDay(true);    	
    	p.config.setDetailsOnCreate(true);
    	p.config.setDetailsOnDblClick(true);
    	
    	
    	/**
    	 * Retrieving team events
    	 */
        p.load("../my/teamEvents", DHXDataFormat.JSON);
        p.data.dataprocessor.setURL("../my/teamEvents");
		
        /**
         * Generating team calendar
         */
		ModelAndView mnv = new ModelAndView("teamCalendar");
		mnv.addObject("body", p.render());
        return mnv;	
	}
	/**
	 * Retrieving Team Events
	 */
	@RequestMapping("/my/teamEvents")
    @ResponseBody public String teamEvents(HttpServletRequest request) { 
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		
	    User user = userService.getUser(username);
	    
    	TeamEventManager evs = new TeamEventManager(request,teamEventService,eventService,user);
    	return evs.run();
            
    }
	
	/**
	 * Doctor's calendar feature
	 */
	@RequestMapping("/my/doctorCalendar")
	public ModelAndView doctorCalendar(WebRequest request, Model model) throws Exception{ 
		/**
		 * Check for authentication of the user
		 */
		if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			return new ModelAndView("redirect:/login");
		}
		
		User user = getUser();
		UserPreference userPref = user.getUserPreference();
		
		
		/**
		 * Initializing Doctor calendar with configurations
		 */
		DHXPlanner p = new DHXPlanner("../codebase_common/", DHXSkin.valueOf(userPref.getSkin()));
        p.config.setFullDay(true);
    	p.config.setMultiDay(true);
    	p.calendars.attachMiniCalendar();
    	p.extensions.add(DHXExtension.TOOLTIP);	    
    	p.templates.setEventText("Appointment: {text}");    	
    	p.config.setDragMove(false);
    	p.toPDF();    	
    	p.config.setDragResize(false);
    	p.config.setDetailsOnCreate(true);
    	p.config.setDetailsOnDblClick(true);
    	
    	
    	
    	//Blocking week ends and weekday's time slots
    	DHXBlockTime sundayBlock = new DHXBlockTime();
    	sundayBlock.setDay(DHXDayOfWeek.SUNDAY);
    	p.timespans.add(sundayBlock);    	
    	DHXBlockTime saturdayBlock = new DHXBlockTime();
    	saturdayBlock.setDay(DHXDayOfWeek.SATURDAY);
    	p.timespans.add(saturdayBlock);    	
    	DHXBlockTime weekdayBlockMorning = new DHXBlockTime();
    	weekdayBlockMorning.setDays(DHXDayOfWeek.MONDAY,DHXDayOfWeek.TUESDAY,DHXDayOfWeek.WEDNESDAY,DHXDayOfWeek.THURSDAY,DHXDayOfWeek.FRIDAY);
    	weekdayBlockMorning.addZone(new DHXZone(0,540));
    	p.timespans.add(weekdayBlockMorning);   	
    	DHXBlockTime weekdayBlockEvening = new DHXBlockTime();
    	weekdayBlockEvening.setDays(DHXDayOfWeek.MONDAY,DHXDayOfWeek.TUESDAY,DHXDayOfWeek.WEDNESDAY,DHXDayOfWeek.THURSDAY,DHXDayOfWeek.FRIDAY);
    	weekdayBlockEvening.addZone(new DHXZone(1200,1440));
    	p.timespans.add(weekdayBlockEvening);
    	
    	
    	/**
    	 * Retrieving doctor's appointments
    	 */
        p.load("../my/doctorEvents", DHXDataFormat.JSON);
        p.data.dataprocessor.setURL("../my/doctorEvents");
		
		ModelAndView mnv = new ModelAndView("doctor");
		mnv.addObject("body", p.render());
        return mnv;	
	}
	
	@RequestMapping("/my/doctorEvents")
    @ResponseBody public String doctorEvents(HttpServletRequest request) { 
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		
	    User user = userService.getUser(username);
	    
	    DoctorAppointmentManager evs = new DoctorAppointmentManager(request,doctorAppointmentService,eventService,user);
    	return evs.run();
            
    }
	
}
