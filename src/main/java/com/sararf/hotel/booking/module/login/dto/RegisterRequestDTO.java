package com.sararf.hotel.booking.module.login.dto;

import com.sararf.hotel.booking.common.validation.ValidPassword;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
@ToString
public class RegisterRequestDTO {
	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotEmpty(message = "Password is required")
	@Length(min = 6, max = 16, message = "Password must be between 6 and 16 characters")
//	@ValidPassword
	private String password;
}
