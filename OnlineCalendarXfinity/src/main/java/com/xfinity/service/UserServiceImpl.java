package com.xfinity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;
import com.xfinity.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User save(User user) {		
		return userRepository.save(user);
	}

	public User getUser(String username) {
		return userRepository.getUser(username);		
	}
	
	@Transactional
	public UserPreference savePreference(UserPreference userPreference) {
		return userRepository.savePreference(userPreference);
	}

}
