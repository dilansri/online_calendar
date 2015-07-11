package com.xfinity.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xfinity.model.User;
 
 
@Repository
public class UserDaoImpl implements UserDao {
 
	@PersistenceContext
	private EntityManager em;
 
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		
		Query query = em.createQuery("from User where username=?").setParameter(1, username);
 
		List<User> users = new ArrayList<User>();
 
		users = query.getResultList();
 
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
 
	}
 
}
