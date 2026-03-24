package com.example.user_service.pojo;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ErrorResponse {
	private String errorMessage;
	private int status;
	private LocalDateTime timestamp;
	
	public ErrorResponse(String errorMessage, int status, LocalDateTime timestamp) {
		this.errorMessage = errorMessage;
		this.status = status;
		this.timestamp = timestamp;
	}

}
