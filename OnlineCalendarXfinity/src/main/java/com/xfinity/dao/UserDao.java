package com.xfinity.dao;

import com.xfinity.model.User;


public interface UserDao {
 
	User findByUserName(String username);
 
}