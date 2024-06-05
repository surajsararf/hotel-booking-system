package com.sararf.hotel.booking.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ValidationFailedException extends CustomException {
	public ValidationFailedException(String message, HttpStatus status) {
		super(message, status);
	}

	public ValidationFailedException(String message, Throwable cause, HttpStatus status) {
		super(message, cause, status);
	}

	public ValidationFailedException(String message, HttpStatus status, String debugMessage) {
		super(message, status, debugMessage);
	}

	public ValidationFailedException(String message, HttpStatus status, List<String> errorList) {
		super(message, status, errorList);
	}

	public ValidationFailedException(String message, HttpStatus status, String debugMessage, List<String> errorList) {
		super(message, status, debugMessage, errorList);
	}
}
