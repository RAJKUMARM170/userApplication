package com.example.userapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired //inject repository dependency
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user); //save student
	}
	
	@Override
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) return user.get();
		return null;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>(); //create list of students variable
		userRepository.findAll().forEach(student ->users.add(student)); // keep each student in students list
		return users;
	}
	
	@Override
	public User updateUser(Long id, User user) {
		Optional<User> userById = userRepository.findById(id);
		
		if(userById.isPresent()) {
			User updatedStudent = userById.get();
		
			updatedStudent.setId(user.getId());
			updatedStudent.setName(user.getName());

			
			return userRepository.save(updatedStudent);
		}
		
		return null;
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id); //delete student by id
		return "id" + id + "is deleted successfully"; 
	}
}
