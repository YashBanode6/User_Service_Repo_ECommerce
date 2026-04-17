package com.example.user_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.dto.UserRequestDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	
	@PostMapping("/create")
	public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		log.info("Received request to create user with email: {}", userRequestDto.getEmail());
		logger.info("Received request to create user with email: {}", userRequestDto.getEmail());
		return userService.createUser(userRequestDto); // Create a new user and return the created user's details
	}
	
	@GetMapping("/all")
	public List<UserResponseDto> getAllUsers() {
		return userService.getAllUsers(); // Return a list of all users
	}
	
	@GetMapping("/email")
	public UserResponseDto getUserByEmail(String email) {
		log.info("Received request to get user with email: {}", email);
		if (email == null || email.isEmpty()) {
			logger.warn("Email parameter is missing or empty");
			throw new IllegalArgumentException("Email parameter is required");
		}
		return userService.getUserByEmail(email); // Return the details of a user based on their email
	}

}
