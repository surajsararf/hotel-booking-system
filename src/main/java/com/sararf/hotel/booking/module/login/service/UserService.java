package com.sararf.hotel.booking.module.login.service;


import com.sararf.hotel.booking.entity.UserEntity;

public interface UserService {
    UserEntity register(UserEntity userEntity);
    String login(String email, String password);
    String generateToken(String email);
}

