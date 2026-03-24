package com.example.user_service.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
