package com.xfinity.repository;

import javax.persistence.PersistenceException;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;

public interface UserRepository {
	User save(User user) throws PersistenceException;

	User getUser(String username);

	UserPreference savePreference(UserPreference userPreference);
}
