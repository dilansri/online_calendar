package com.xfinity.service;

import java.util.List;

import com.xfinity.model.DoctorAppointment;
import com.xfinity.model.TeamEvent;

public interface DoctorAppointmentService {
	
	DoctorAppointment save(DoctorAppointment appointment);

	List<DoctorAppointment> findAllAppointments();

	void update(DoctorAppointment appointment);

	void delete(DoctorAppointment appointment);

	String getUsername(int appointmentId);

	boolean isValid(DoctorAppointment appointment);

}
