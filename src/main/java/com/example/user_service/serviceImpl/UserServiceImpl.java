package com.example.user_service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user_service.dto.UserRequestDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.entity.User;
import com.example.user_service.repo.UserRepository;
import com.example.user_service.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository; 
	
	public UserResponseDto mapToResponseDto(User user) {
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getId());
		userResponseDto.setName(user.getName());
		userResponseDto.setEmail(user.getEmail());
		userResponseDto.setLocalDateTime(user.getCreatedAt());

		return userResponseDto;
	}
	
	public User mapToEntity(UserRequestDto userRequestDto) {
		User user = new User();
		user.setName(userRequestDto.getName());
		user.setEmail(userRequestDto.getEmail());
		user.setPassword(userRequestDto.getPassword());

		return user;
	}
	
	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		User user = mapToEntity(userRequestDto); // Convert the request DTO to a User entity
		log.info("Creating user: {}", user); // Log the user being created
		User savedUser = userRepository.save(user); // Save the user to the database
		log.info("User created with ID: {}", savedUser); // Log the ID of the created user
		return mapToResponseDto(savedUser); // Convert the saved User entity back to a response DTO and return it
	}

	
	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> users = userRepository.findAll(); // Retrieve all users from the database
		return users.stream()
				.map(this::mapToResponseDto) // Convert each User entity to UserResponseDto
				.toList(); // Collect the results into a List
	}

	

}
