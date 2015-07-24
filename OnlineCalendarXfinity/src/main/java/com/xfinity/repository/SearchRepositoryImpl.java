package com.xfinity.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xfinity.model.Event;
@Repository("searchRepository")
public class SearchRepositoryImpl implements SearchRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List<Event> search(Date startDate, Date endDate,String username) {
		
		Query query = em.createQuery("from Event where start_date >= :startDate and end_date <= :endDate and username = :username ORDER BY start_date")
						.setParameter("startDate", startDate)
						.setParameter("endDate", endDate)
						.setParameter("username", username);	


		List<Event> searchResult = new ArrayList<Event>();
		
		searchResult = query.getResultList();
		return searchResult;
	}

}
