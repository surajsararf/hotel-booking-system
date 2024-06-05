package com.sararf.hotel.booking.utils;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.login.dto.RegisterRequestDTO;
import com.sararf.hotel.booking.module.login.dto.UserRegisterResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUtils {

	public UserEntity toUserEntity(RegisterRequestDTO registerRequestDTO) {
		return UserEntity.builder()
				.name(registerRequestDTO.getName())
				.email(registerRequestDTO.getEmail())
				.password(registerRequestDTO.getPassword())
				.build();
	}

	public UserRegisterResponse toUserRegisterResponse(UserEntity userEntity, String token) {
		return UserRegisterResponse.builder()
				.name(userEntity.getName())
				.email(userEntity.getEmail())
				.token(token)
				.build();
	}
}
