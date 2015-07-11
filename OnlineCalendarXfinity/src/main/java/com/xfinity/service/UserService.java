package com.xfinity.service;

import com.xfinity.model.User;

public interface UserService {
	User save(User user);
	
	User getUser(String username);
}
