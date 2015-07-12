package com.xfinity.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.xfinity.model.SharedCalendar;
@Repository("calendarRepository")
public class CalendarRepositoryImpl implements CalendarRepository {
	
	@PersistenceContext
	private EntityManager em;

	public SharedCalendar saveSharedCalendar(SharedCalendar calendar) {
		em.persist(calendar);
		em.flush();
		return calendar;
	}

}
