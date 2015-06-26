package com.xfinity.event.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.xfinity.model.Event;
import com.xfinity.service.EventService;

public class EventManager extends DHXEventsManager {
	
	private EventService eventService;

	public EventManager(HttpServletRequest request,EventService service) {
		super(request);
		eventService = service;
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
		if (status == DHXStatus.INSERT){
			eventService.save(ev);
		}else if (status == DHXStatus.UPDATE){
			
		}
		return status;
	}
	
	

}
