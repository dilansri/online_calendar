package com.xfinity.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xfinity.model.DoctorAppointment;
import com.xfinity.model.TeamEvent;

@Repository("doctorAppointmentRepository")
public class DoctorAppointmentRepositoryImpl implements
		DoctorAppointmentRepository {
	
	@PersistenceContext
	private EntityManager em;

	public DoctorAppointment save(DoctorAppointment appointment) {
		em.persist(appointment);
		em.flush();
		
		return appointment;
	}

	public List<DoctorAppointment> loadAll() {
		Query query = em.createQuery("Select e from DoctorAppointment e");		
		
		List appointments = query.getResultList();
		
		return appointments;
	}

	public void delete(DoctorAppointment appointment) {
		em.remove(em.contains(appointment) ? appointment : em.merge(appointment));
		em.flush();

	}

	public void update(DoctorAppointment appointment) {
		em.persist(em.contains(appointment) ? appointment : em.merge(appointment));
		em.flush();

	}

	public String getUsername(int appointmentId) {
		Query query = em.createQuery("from DoctorAppointment where id=?").setParameter(1, appointmentId);
		List<DoctorAppointment> appointments = new ArrayList<DoctorAppointment>();
		
		appointments = query.getResultList();
		
		if (appointments.size() > 0) {
			return appointments.get(0).getUser().getUsername();
		}
		return null;
	}

}
