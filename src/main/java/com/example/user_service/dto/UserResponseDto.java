package com.example.user_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponseDto {
	
	private Long id;
	private String name;
	private String email;
	private LocalDateTime localDateTime;
}
