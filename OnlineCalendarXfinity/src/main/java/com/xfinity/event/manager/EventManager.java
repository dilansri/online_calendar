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
	

	public EventManager(HttpServletRequest request,EventService service,UserService uService,User usr,HashMap<String, String> opt) {
		super(request);
		eventService = service;
		userService = uService;
		options = opt;
	    user = usr;
	}
	
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new Event();
	}
	
	@Override
    public Iterable getEvents() {
		List<Event> events = eventService.findAllEvents(user.getUsername(),options);
		
		
		return events;
	}
	
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		//eventService.save(event);
		Event ev = (Event)event;
		
		//ev.setColor("orange");	    
	    ev.setUser(user);
	    ev.setColor();
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
