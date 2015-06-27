package com.xfinity.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xfinity.model.Event;

@Repository("eventRepository")
public class EventRepositoryImpl implements EventRepository {
	
	
	@PersistenceContext
	private EntityManager em;

	public Event save(Event event) {
		em.persist(event);
		em.flush();
		
		return event;
	}

	public List<Event> loadAll() {
		Query query = em.createQuery("Select e from Event e");
		
		
		List events = query.getResultList();
		
		return events;
	}

	public void delete(Event ev) {
		em.remove(em.contains(ev) ? ev : em.merge(ev));
		em.flush();
		
	}

	public void update(Event ev) {
		em.persist(em.contains(ev) ? ev : em.merge(ev));
		em.flush();
		
	}

}
 