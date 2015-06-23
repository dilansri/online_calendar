package com.xfinity.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.xfinity.model.Event;

import org.springframework.stereotype.Repository;

@Repository("eventRepository")
public class EventRepositoryImpl implements EventRepository {
	
	
	@PersistenceContext
	private EntityManager em;

	public Event save(Event event) {
		em.persist(event);
		em.flush();
		
		return event;
	}

}
