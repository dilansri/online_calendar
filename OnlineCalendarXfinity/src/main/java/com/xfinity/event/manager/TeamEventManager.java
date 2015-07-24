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
	
	/**
	 * Initializing Team Event manager with services
	 */
	public TeamEventManager(HttpServletRequest request,TeamEventService service,EventService eService,User usr) {
		super(request);
		teamEventService = service;
		user = usr;
		eventService = eService;
	}
	
	/**
	 * Creation of team event object
	 */
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new TeamEvent();
	}
	
	/**
	 * Getting all the team events
	 */
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
	
	/**
	 * Handling adding, deleting, and modifying of team events
	 */
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		//eventService.save(event);
		TeamEvent ev = (TeamEvent)event;
		ev.setUser(user);
		ev.setColor();
		
		/**
		 * CHeck for authorization for modification and delete
		 */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String currentUser = auth.getName(); 
	    
	    if (status == DHXStatus.UPDATE || status == DHXStatus.DELETE){
	    	int eventId = ev.getId();	    	
	    	String eventUser = teamEventService.getUsername(eventId);
		    
		    if(!currentUser.equals(eventUser)){
		    	return DHXStatus.ERROR;
		    }
	    	
	    }
	    
	    /**
	     * Syncing team event with personal calendar
	     */
	    ev.setUser(user);
	    Event teamEvent = new Event();
	    teamEvent.setStart_date(ev.getStart_date());
	    teamEvent.setEnd_date(ev.getEnd_date());
	    teamEvent.setText("Team Event :"+ev.getText());
	    teamEvent.setUser(user);
	    teamEvent.setTeamColor();
	    
	    /**
	     * Persisting new and modified team events
	     */
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
