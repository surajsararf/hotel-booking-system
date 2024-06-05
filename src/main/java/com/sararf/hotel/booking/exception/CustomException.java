package com.sararf.hotel.booking.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {
	private HttpStatus status;
	private String message;
	private String debugMessage;
	private List<String> errorList;

	public CustomException(String message, HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}

	public CustomException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.message = message;
		this.status = status;
	}

	public CustomException(String message, HttpStatus status, String debugMessage) {
		super(message);
		this.message = message;
		this.status = status;
		this.debugMessage = debugMessage;
	}

	public CustomException(String message, HttpStatus status, List<String> errorList) {
		super(message);
		this.message = message;
		this.status = status;
		this.errorList = errorList;
	}

	public CustomException(String message, HttpStatus status, String debugMessage, List<String> errorList) {
		super(message);
		this.message = message;
		this.status = status;
		this.debugMessage = debugMessage;
		this.errorList = errorList;
	}
}

