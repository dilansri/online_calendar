package com.xfinity.event.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.xfinity.model.DoctorAppointment;
import com.xfinity.model.User;
import com.xfinity.service.DoctorAppointmentService;

public class DoctorAppointmentManager extends DHXEventsManager {
	
	private DoctorAppointmentService doctorAppointmentService;
	private User user;
	
	public DoctorAppointmentManager(HttpServletRequest request,DoctorAppointmentService service,User usr) {
		super(request);
		doctorAppointmentService = service;
		user = usr;
	}
	
	
	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		
		return new DoctorAppointment();
	}
	
	
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
	
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		//eventService.save(event);
		DoctorAppointment appointment = (DoctorAppointment)event;
		appointment.setColor();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String currentUser = auth.getName(); 
	    
	    if(status == DHXStatus.INSERT){
	    	
	    	//CHECK For overlaps
	    	if(!doctorAppointmentService.isValid(appointment)){
	    		return DHXStatus.ERROR;
	    	}
	    	
	    }else if (status == DHXStatus.UPDATE || status == DHXStatus.DELETE){
	    	int appointmentId = appointment.getId();	    	
	    	String eventUser = doctorAppointmentService.getUsername(appointmentId);
		    
		    if(!currentUser.equals(eventUser)){
		    	return DHXStatus.ERROR;
		    }
	    	
	    }
	    
	    appointment.setUser(user);
	    
		//ev.setColor("orange");	    
	    //ev.setUser(user);
		if (status == DHXStatus.INSERT){
			doctorAppointmentService.save(appointment);
		}else if (status == DHXStatus.UPDATE){
			doctorAppointmentService.update(appointment);
		}else if(status == DHXStatus.DELETE){
			doctorAppointmentService.delete(appointment);
		}
		return status;
	}

}
