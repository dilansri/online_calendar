package com.xfinity.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.xfinity.model.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	public User save(User user) {
		em.persist(user);
		em.flush();
		return user;
	}

}
