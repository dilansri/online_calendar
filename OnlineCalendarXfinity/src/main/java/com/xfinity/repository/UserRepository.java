package com.xfinity.repository;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;

public interface UserRepository {
	User save(User user);

	User getUser(String username);

	UserPreference savePreference(UserPreference userPreference);
}
