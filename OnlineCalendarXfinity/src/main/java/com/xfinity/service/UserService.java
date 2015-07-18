package com.xfinity.service;

import javax.persistence.PersistenceException;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;

public interface UserService {
	User save(User user) throws PersistenceException;
	
	User getUser(String username);

	UserPreference savePreference(UserPreference userPreference);
}
