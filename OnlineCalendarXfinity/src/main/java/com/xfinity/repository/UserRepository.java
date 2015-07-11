package com.xfinity.repository;

import com.xfinity.model.User;

public interface UserRepository {
	User save(User user);

	User getUser(String username);
}
