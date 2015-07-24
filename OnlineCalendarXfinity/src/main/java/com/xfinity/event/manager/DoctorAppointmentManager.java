package com.xfinity.event.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.xfinity.model.DoctorAppointment;
import com.xfinity.model.Event;
import com.xfinity.model.User;
import com.xfinity.service.DoctorAppointmentService;
import com.xfinity.service.EventService;

public class DoctorAppointmentManager extends DHXEventsManager {
	
	private DoctorAppointmentService doctorAppointmentService;
	private User user;
	private EventService eventService;
	
	/**
	 * Initializing the appointment manager with service
	 */
	public DoctorAppointmentManager(HttpServletRequest request,DoctorAppointmentService service,EventService eService,User usr) {
		super(request);
		doctorAppointmentService = service;
		eventService = eService;
		user = usr;
	}
	
	/*
	 * Creation of new Appointment 
	 */
	
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new DoctorAppointment();
	}
	
	/**
	 * Sending all the appointments to the doctor calendar
	 */
	@Override
    public Iterable getEvents() {
		List<DoctorAppointment> appointments = doctorAppointmentService.findAllAppointments();	
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String currentUser = auth.getName(); 
		
		for(DoctorAppointment appointment : appointments){
			if(!appointment.getUser().getUsername().equals(currentUser)){
				appointment.setText("Booked");
			}
		}
		return appointments;
	}
	/*
	 *Managing creatingdeleting and modification of the events and persist them.
	 */
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		/**
		 * Setting appointment properties
		 */
		DoctorAppointment appointment = (DoctorAppointment)event;
		appointment.setUser(user);
		appointment.setColor();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String currentUser = auth.getName(); 
	    
	    /**
	     * Checking for the validity of the appointment
	     */
	    
	    if(!doctorAppointmentService.isValid(appointment)){
    		return DHXStatus.ERROR;
    	}
	    
	    if (status == DHXStatus.UPDATE || status == DHXStatus.DELETE){
	    	int appointmentId = appointment.getId();	    	
	    	String eventUser = doctorAppointmentService.getUsername(appointmentId);
		    
		    if(!currentUser.equals(eventUser)){
		    	return DHXStatus.ERROR;
		    }
	    	
	    }
	    
	    appointment.setUser(user);
	    
	    
	    /**
	     * Syncing appointment with user's personal planner
	     */
	    Event personalEvent = new Event();
	    personalEvent.setStart_date(appointment.getStart_date());
	    personalEvent.setEnd_date(appointment.getEnd_date());
	    personalEvent.setText("See Doctor :"+appointment.getText());
	    personalEvent.setUser(user);
	    personalEvent.setColor();
	    
	    /**
	     * Using services to store the appointment
	     */
		if (status == DHXStatus.INSERT){
			doctorAppointmentService.save(appointment);
			eventService.save(personalEvent);
		}else if (status == DHXStatus.UPDATE){
			doctorAppointmentService.update(appointment);
		}else if(status == DHXStatus.DELETE){
			doctorAppointmentService.delete(appointment);
		}
		return status;
	}

}
