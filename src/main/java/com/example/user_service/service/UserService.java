package com.example.user_service.service;

import java.util.List;

import com.example.user_service.dto.UserRequestDto;
import com.example.user_service.dto.UserResponseDto;

public interface UserService {
	
	UserResponseDto createUser(UserRequestDto userRequestDto);
	
	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserByEmail(String email);
}
