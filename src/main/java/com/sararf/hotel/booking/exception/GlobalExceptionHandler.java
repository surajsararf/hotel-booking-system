package com.sararf.hotel.booking.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
		log.info("Handling CustomException: {}", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setSuccess(false);
		errorResponse.setStatusCode(ex.getStatus().toString());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDebugMessage(ex.getDebugMessage());
		errorResponse.setErrors(ex.getErrorList());
		return new ResponseEntity<>(errorResponse, ex.getStatus());
	}
}

