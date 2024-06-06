package com.sararf.hotel.booking.module.login.controller;

import com.sararf.hotel.booking.common.dto.ResponseWrapperDTO;
import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.login.dto.LoginRequestDTO;
import com.sararf.hotel.booking.module.login.dto.RegisterRequestDTO;
import com.sararf.hotel.booking.module.login.dto.UserRegisterResponse;
import com.sararf.hotel.booking.module.login.service.UserService;
import com.sararf.hotel.booking.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/app/v1/user")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Login and registration APIs", value = "Login and registration APIs")
public class UserController {
	private final UserService userService;

	@PostMapping("/register")
	@ApiOperation(value = "Register a new user", notes = "Register a new user")
	public ResponseEntity<ResponseWrapperDTO<UserRegisterResponse>> register(@RequestBody @Valid RegisterRequestDTO registerRequest) {
		log.info("Registering user: {}", registerRequest);
		if (!Objects.isNull(userService.findByEmail(registerRequest.getEmail()))) {
			log.error("User already exists with email id {}", registerRequest.getEmail());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(ResponseWrapperDTO.badRequest("User already exists", null));
		}
		UserEntity registeredUser = userService.register(UserUtils.toUserEntity(registerRequest));
		String token = userService.generateToken(registeredUser.getEmail());
		return ResponseEntity.ok(ResponseWrapperDTO.ok(UserUtils.toUserRegisterResponse(registeredUser, token), "Registration successful"));
	}

	@PostMapping("/login")
	@ApiOperation(value = "Login a user", notes = "Login a user")
	public ResponseEntity<ResponseWrapperDTO<?>> login(@RequestBody @Valid LoginRequestDTO loginRequest) {
		log.info("Logging in user: {}", loginRequest);
		try {
			String token = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
			return ResponseEntity.ok(ResponseWrapperDTO.ok(token, "Login successful"));
		} catch (AuthenticationException e) {
			log.error("Invalid password", e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(ResponseWrapperDTO.failedLogin(e.getMessage()));
		}
	}
}

