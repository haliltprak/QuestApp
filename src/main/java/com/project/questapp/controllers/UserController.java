package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.questapp.entity.User;
import com.project.questapp.repos.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		newUser.setId(0L);
		return userRepository.save(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable  Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else {
			return null;
		}
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId){
		userRepository.deleteById(userId);
	}

}










