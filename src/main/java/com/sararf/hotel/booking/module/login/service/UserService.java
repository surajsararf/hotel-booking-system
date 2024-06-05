package com.sararf.hotel.booking.module.login.service;


import com.sararf.hotel.booking.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity register(UserEntity userEntity);
    String login(String email, String password);
    String generateToken(String email);
    UserEntity findByEmail(String email);
}

