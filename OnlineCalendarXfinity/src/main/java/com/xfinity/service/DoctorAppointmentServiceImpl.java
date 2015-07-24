package com.xfinity.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfinity.model.DoctorAppointment;
import com.xfinity.repository.DoctorAppointmentRepository;

@Service("doctorAppointmentService")
public class DoctorAppointmentServiceImpl implements DoctorAppointmentService {
	
	@Autowired
	private DoctorAppointmentRepository doctorAppointmentRepository;
	
	private int max_allowed_hours = 2;
	private int min_allowed_minutes = 15;
	
	@Transactional
	public DoctorAppointment save(DoctorAppointment appointment) {
		return doctorAppointmentRepository.save(appointment);
	}

	public List<DoctorAppointment> findAllAppointments() {
		return doctorAppointmentRepository.loadAll();
	}
	
	@Transactional
	public void update(DoctorAppointment appointment) {
		doctorAppointmentRepository.update(appointment);
	}
	
	@Transactional
	public void delete(DoctorAppointment appointment) {
		doctorAppointmentRepository.delete(appointment);
	}

	public String getUsername(int appointmentId) {		
		return doctorAppointmentRepository.getUsername(appointmentId);
	}

	public boolean isValid(DoctorAppointment appointment) {
		if(doctorAppointmentRepository.isValid(appointment) 
				&& getMinutes(appointment) < max_allowed_hours * 60 
				&& getMinutes(appointment) > min_allowed_minutes
				&& appointment.getStart_date().after(new Date())){
			return true;
		}
		
		return false;
	}

	private int getMinutes(DoctorAppointment appointment) {
		Date startTime = appointment.getStart_date();
		Date endTime = appointment.getEnd_date();
		
		long diff = endTime.getTime() - startTime.getTime();
		long minutes = diff/(1000*60);		
		return (int)minutes;
	}

}
