package com.xfinity.event.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.xfinity.model.Event;
import com.xfinity.model.User;
import com.xfinity.service.EventService;
import com.xfinity.service.UserService;

public class SharedEventManager extends DHXEventsManager {
	
private EventService eventService;
	
	private UserService userService;
	
	private User user;
	

	public SharedEventManager(HttpServletRequest request,EventService service,UserService uService,User usr) {
		super(request);
		eventService = service;
		userService = uService;
		
	    user = usr;
	}
	
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new Event();
	}
	
	@Override
    public Iterable getEvents() {
		List<Event> events = eventService.findAllEvents(user.getUsername());
		for(Event ev:events){
			ev.setText("");
		}
		return events;
	}
	
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		//eventService.save(event);
		Event ev = (Event)event;
		ev.setColor();
		//ev.setColor("orange");	    
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
