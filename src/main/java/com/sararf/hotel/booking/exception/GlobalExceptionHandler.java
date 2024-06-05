package com.sararf.hotel.booking.exception;

import com.sararf.hotel.booking.common.ResponseWrapperDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseWrapperDTO<?>> handleCustomException(CustomException ex) {
		log.info("Handling CustomException: {}", ex.getMessage());
		ResponseWrapperDTO<Object> errorResponse = ResponseWrapperDTO.builder()
				.success(false)
				.statusCode(ex.getStatus().value())
				.errorList(ex.getErrorList())
				.debugMessage(ex.getDebugMessage())
				.message(ex.getMessage())
				.build();

		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
		List<String> errorMap = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			errorMap.add(error.getDefaultMessage());
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseWrapperDTO.badRequest("Validation Failed", errorMap));
	}
}

