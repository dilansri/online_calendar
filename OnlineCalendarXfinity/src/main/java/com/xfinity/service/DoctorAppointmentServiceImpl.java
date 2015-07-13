package com.xfinity.service;

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

}
