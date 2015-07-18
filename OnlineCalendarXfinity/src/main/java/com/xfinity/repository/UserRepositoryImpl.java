package com.xfinity.repository;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	public User save(User user) throws PersistenceException {
		em.persist(user);
		em.flush();
		return user;
	}

	@SuppressWarnings("unchecked")
	public User getUser(String username) {
		Query query = em.createQuery("from User where username=?").setParameter(1, username);
		
		List<User> users = new ArrayList<User>();
		 
		users = query.getResultList();
 
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public UserPreference savePreference(UserPreference userPreference) {
		em.persist(em.contains(userPreference) ? userPreference : em.merge(userPreference));
		em.flush();
		return userPreference;
	}

}
