package com.project.questapp.controllers;

import java.util.List;

import com.project.questapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.questapp.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return  userService.createUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable  Long userId) {
		return userService.getOneUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId){
		userService.deleteById(userId);
	}

}










