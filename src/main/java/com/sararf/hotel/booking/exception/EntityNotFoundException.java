package com.sararf.hotel.booking.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class EntityNotFoundException extends CustomException {
	public EntityNotFoundException(String message, HttpStatus status) {
		super(message, status);
	}

	public EntityNotFoundException(String message, Throwable cause, HttpStatus status) {
		super(message, cause, status);
	}

	public EntityNotFoundException(String message, HttpStatus status, String debugMessage) {
		super(message, status, debugMessage);
	}

	public EntityNotFoundException(String message, HttpStatus status, List<String> errorList) {
		super(message, status, errorList);
	}

	public EntityNotFoundException(String message, HttpStatus status, String debugMessage, List<String> errorList) {
		super(message, status, debugMessage, errorList);
	}
}
