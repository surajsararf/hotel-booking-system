package com.sararf.hotel.booking.module.login.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterResponse {
	private String name;
	private String email;
	private String token;
}
