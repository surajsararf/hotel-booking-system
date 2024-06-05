package com.sararf.hotel.booking.module.login.service.impl;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.exception.EntityNotFoundException;
import com.sararf.hotel.booking.module.login.dao.UserRepository;
import com.sararf.hotel.booking.module.login.service.UserService;
import com.sararf.hotel.booking.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenUtil jwtTokenUtil;
	private final AuthenticationManager authenticationManager;

	@Override
	public UserEntity register(UserEntity user) {
		log.info("Registering user: {}", user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

	@Override
	public String login(String email, String password) {
		log.info("Logging in user: {}", email);
		final UserEntity user = userRepository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException("User not found", HttpStatus.NOT_FOUND));
		Authentication authentication = authenticate(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtTokenUtil.generateToken(email);
	}

	@Override
	public String generateToken(String email) {
		return jwtTokenUtil.generateToken(email);
	}

	private Authentication authenticate(String email, String password) {
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	}
}
