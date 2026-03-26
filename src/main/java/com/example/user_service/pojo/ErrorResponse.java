package com.example.user_service.pojo;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;

@Data
public class ErrorResponse {
	private String message;
	private int status;
	private LocalDateTime timestamp;
	
	public ErrorResponse(String message, int status, LocalDateTime timestamp) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

}
