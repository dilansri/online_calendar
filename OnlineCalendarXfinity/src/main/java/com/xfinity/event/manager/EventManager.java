package com.xfinity.event.manager;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.xfinity.model.Event;
import com.xfinity.model.User;
import com.xfinity.service.EventService;
import com.xfinity.service.UserService;

public class EventManager extends DHXEventsManager {
	
	private EventService eventService;
	
	private UserService userService;
	
	private User user;
	
	HashMap<String, String> options;
	
	/**
	 * 
	 * Initializing the manager with services
	 */
	public EventManager(HttpServletRequest request,EventService service,UserService uService,User usr,HashMap<String, String> opt) {
		super(request);
		eventService = service;
		userService = uService;
		options = opt;
	    user = usr;
	}
	
	/**
	 * Creation of the event object
	 */
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new Event();
	}
	
	/**
	 * Getting all the personal calendar's events of the user
	 */
	@Override
    public Iterable getEvents() {
		List<Event> events = eventService.findAllEvents(user.getUsername(),options);
		/**
		 * Applying user color preferences
		 */
		if(!user.getUserPreference().isKeepOldColors()){
			for(Event ev:events){
				ev.setUser(user);
				ev.setColor();
			}
		}
		return events;
	}
	
	/**
	 * Creating , deleting , and updating users  personal planner's events
	 */
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		Event ev = (Event)event;
	    ev.setUser(user);
	    ev.setColor();	    
	    
	    
		if (status == DHXStatus.INSERT){
			eventService.save(ev);
		}else if (status == DHXStatus.UPDATE){
			System.out.println("StartDate"+ev.getStart_date());
			eventService.update(ev);
		}else if(status == DHXStatus.DELETE){
			eventService.delete(ev);
		}
		return status;
	}
	
	

}
