package com.xfinity.repository;

import java.util.List;

import com.xfinity.model.DoctorAppointment;

public interface DoctorAppointmentRepository {
	
	DoctorAppointment save(DoctorAppointment appointment);

	List<DoctorAppointment> loadAll();

	void delete(DoctorAppointment appointment);

	void update(DoctorAppointment appointment);

	String getUsername(int appointmentId);

	boolean isValid(DoctorAppointment appointment);

}
