package com.sararf.hotel.booking.common;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseWrapperDTO<T> {
	private boolean success;
	private String message;
	private String debugMessage;
	private List<String> errorList;
	private T data;
	private int statusCode;

	// Static methods for creating response instances
	public static <T> ResponseWrapperDTO<T> ok(T data, String message) {
		return ResponseWrapperDTO.<T>builder()
				.success(true)
				.message(message)
				.data(data)
				.statusCode(200)
				.build();
	}

	public static <T> ResponseWrapperDTO<T> badRequest(String message, List<String> errorList) {
		return ResponseWrapperDTO.<T>builder()
				.success(false)
				.message(message)
				.errorList(errorList)
				.statusCode(400)
				.build();
	}
}

