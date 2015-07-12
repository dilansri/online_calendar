package com.xfinity.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xfinity.model.TeamEvent;

@Repository("teamEventRepository")
public class TeamEventRepositoryImpl implements TeamEventRepository {
	
	@PersistenceContext
	private EntityManager em;

	public TeamEvent save(TeamEvent event) {
		em.persist(event);
		em.flush();
		
		return event;
	}

	public List<TeamEvent> loadAll() {
		Query query = em.createQuery("Select e from TeamEvent e");		
		
		List events = query.getResultList();
		
		return events;
	}

	public void delete(TeamEvent ev) {
		em.remove(em.contains(ev) ? ev : em.merge(ev));
		em.flush();
	}

	public void update(TeamEvent ev) {
		em.persist(em.contains(ev) ? ev : em.merge(ev));
		em.flush();
	}

	public String getUsername(int eventId) {
		Query query = em.createQuery("from TeamEvent where id=?").setParameter(1, eventId);
		List<TeamEvent> events = new ArrayList<TeamEvent>();
		
		events = query.getResultList();
		
		if (events.size() > 0) {
			return events.get(0).getUser().getUsername();
		}
		return null;
	}

}
