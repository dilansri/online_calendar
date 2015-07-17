package com.xfinity.event.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.xfinity.model.Event;
import com.xfinity.model.TeamEvent;
import com.xfinity.model.User;
import com.xfinity.service.EventService;
import com.xfinity.service.TeamEventService;

public class TeamEventManager extends DHXEventsManager {
	
	private TeamEventService teamEventService;
	private User user;
	private EventService eventService;
	
	public TeamEventManager(HttpServletRequest request,TeamEventService service,EventService eService,User usr) {
		super(request);
		teamEventService = service;
		user = usr;
		eventService = eService;
	}
	
	
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new TeamEvent();
	}
	
	
	@Override
    public Iterable getEvents() {
		List<TeamEvent> events = teamEventService.findAllEvents();	
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String currentUser = auth.getName(); 
		
		for(TeamEvent evt : events){
			if(!evt.getUser().getUsername().equals(currentUser)){
				evt.setText(evt.getText()+" :"+evt.getUser().getUsername());
			}
		}
		return events;
	}
	
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		//eventService.save(event);
		TeamEvent ev = (TeamEvent)event;
		ev.setColor();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String currentUser = auth.getName(); 
	    
	    if (status == DHXStatus.UPDATE || status == DHXStatus.DELETE){
	    	int eventId = ev.getId();	    	
	    	String eventUser = teamEventService.getUsername(eventId);
		    
		    if(!currentUser.equals(eventUser)){
		    	return DHXStatus.ERROR;
		    }
	    	
	    }
	    
	    ev.setUser(user);
	    
	    Event teamEvent = new Event();
	    teamEvent.setStart_date(ev.getStart_date());
	    teamEvent.setEnd_date(ev.getEnd_date());
	    teamEvent.setText("Team Event :"+ev.getText());
	    teamEvent.setUser(user);
	    teamEvent.setColor();
	    
	    
	    
		//ev.setColor("orange");	    
	    //ev.setUser(user);
		if (status == DHXStatus.INSERT){
			teamEventService.save(ev);
			eventService.save(teamEvent);
		}else if (status == DHXStatus.UPDATE){
			teamEventService.update(ev);
		}else if(status == DHXStatus.DELETE){
			teamEventService.delete(ev);
		}
		return status;
	}

}
