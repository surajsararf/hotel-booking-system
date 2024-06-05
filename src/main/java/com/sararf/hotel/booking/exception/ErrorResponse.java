package com.sararf.hotel.booking.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {
	private LocalDateTime timestamp;
	private boolean success;
	private String message;
	private String statusCode;
	private String debugMessage;
	private List<String> errors;
}

