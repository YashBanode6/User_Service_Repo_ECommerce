package com.example.user_service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.user_service.dto.UserRequestDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.entity.User;
import com.example.user_service.exception.UserAlreadyExistsException;
import com.example.user_service.repo.UserRepository;
import com.example.user_service.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository; 
	private final ModelMapper modelMapper; // For mapping between DTOs and entities
	
	private UserResponseDto mapToResponseDto(User user) {
		UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class); // Map User entity to UserResponseDto

		// Manually set the fullName field in the response DTO
		log.info("Mapping User entity to UserResponseDto for user with email {}", user.getEmail());
		return userResponseDto;
	}
	
	private User mapToEntity(UserRequestDto userRequestDto) {
		User user = modelMapper.map(userRequestDto, User.class); // Map UserRequestDto to User entity
		
		log.info("Mapping UserRequestDto to User entity for email {}", userRequestDto.getEmail());
		return user;
	}
	
	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		
		if (userRepository.existsByEmail(userRequestDto.getEmail())) {
			log.warn("User with email {} already exists", userRequestDto.getEmail());
			throw new UserAlreadyExistsException(
					"User with email " + userRequestDto.getEmail() + " already exists");
		}
		
		User user = mapToEntity(userRequestDto); // Convert the request DTO to a User entity
		User savedUser = userRepository.save(user); // Save the user to the database
		log.info("User with email {} created successfully", savedUser.getEmail());
		return mapToResponseDto(savedUser); // Convert the saved User entity back to a response DTO and return it
	}

	
	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> users = userRepository.findAll(); // Retrieve all users from the database
		return users.stream()
				.map(this::mapToResponseDto) // Convert each User entity to UserResponseDto
				.toList(); // Collect the results into a List
	}

	@Override
	public UserResponseDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		log.info("Fetching user with email: {}", email);
		return null;
	}

	

}
