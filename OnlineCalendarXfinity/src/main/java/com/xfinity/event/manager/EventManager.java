package com.xfinity.event.manager;

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
	

	public EventManager(HttpServletRequest request,EventService service,UserService uService) {
		super(request);
		eventService = service;
		userService = uService;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		
	    user = userService.getUser(username);
	}
	
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new Event();
	}
	
	@Override
    public Iterable getEvents() {
		List<Event> events = eventService.findAllEvents();
		return events;
	}
	
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		//eventService.save(event);
		Event ev = (Event)event;
		
		
	    
	    ev.setUser(user);
	    
		if (status == DHXStatus.INSERT){
			eventService.save(ev);
		}else if (status == DHXStatus.UPDATE){
			eventService.update(ev);
		}else if(status == DHXStatus.DELETE){
			eventService.delete(ev);
		}
		return status;
	}
	
	

}
