package com.example.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapp.model.User;
import com.example.userapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser(){
	 	return userService.getAllUser();
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}

}
