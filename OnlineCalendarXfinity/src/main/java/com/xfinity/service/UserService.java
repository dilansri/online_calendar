package com.xfinity.service;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;

public interface UserService {
	User save(User user);
	
	User getUser(String username);

	UserPreference savePreference(UserPreference userPreference);
}
