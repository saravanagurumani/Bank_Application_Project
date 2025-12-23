package com.example.BankApplication.registration.service;


import com.example.BankApplication.registration.dto.ChangePasswordDto;
import com.example.BankApplication.registration.dto.UserDto;
import com.example.BankApplication.registration.models.User;

import java.util.Map;

public interface UserServiceInter {

    User register(UserDto dto);
    String login(UserDto dto);
    String logout(Integer id);
    String changePassword(ChangePasswordDto dto);
    Map<String, Object> getProfile(String userName);
    String updateProfile(UserDto dto);
}
