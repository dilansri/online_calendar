package com.xfinity.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	public boolean isCalendarShared(String sharedBy, String sharedWith) {
		Query query = em.createQuery("from SharedCalendar where sharedBy=? and sharedWith=?")
					.setParameter(1, sharedBy)
					.setParameter(2, sharedWith);
		
		List<SharedCalendar> shared = new ArrayList<SharedCalendar>();
		
		shared = query.getResultList();
		
		if (shared.size() > 0) {
			return true;
		}
		
		return false;
	}

}
