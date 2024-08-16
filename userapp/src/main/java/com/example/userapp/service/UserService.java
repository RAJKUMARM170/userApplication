package com.example.userapp.service;

import java.util.List;

import com.example.userapp.model.User;

public interface UserService {
	
	List<User> getAllUser();
	User getUserById(Long id);
	User saveUser(User user);
	String deleteUser(Long id);
	User updateUser(Long id, User user);
	

}
