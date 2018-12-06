package com.techm.ms.service;

import java.util.List;

import com.techm.ms.model.User;

public interface UserService {

	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	List<User> findAllUsers();
	
	boolean isUserExist(User user);
	
	User createUser(User user);
	
	
}
