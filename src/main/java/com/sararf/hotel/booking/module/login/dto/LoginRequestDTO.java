package com.sararf.hotel.booking.module.login.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequestDTO {
	@NotEmpty(message = "email is required")
	private String email;

	@NotEmpty(message = "Password is required")
	private String password;
}

