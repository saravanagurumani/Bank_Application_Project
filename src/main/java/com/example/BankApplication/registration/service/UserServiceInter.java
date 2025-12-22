package com.example.BankApplication.registration.service;


import com.example.BankApplication.registration.dto.UserDto;
import com.example.BankApplication.registration.models.User;

public interface UserServiceInter {

    User register(UserDto dto);
    String login(UserDto dto);
}
