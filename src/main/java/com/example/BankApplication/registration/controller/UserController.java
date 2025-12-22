package com.example.BankApplication.registration.controller;

import com.example.BankApplication.registration.dto.UserDto;
import com.example.BankApplication.registration.models.User;
import com.example.BankApplication.registration.service.UserServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserServiceInter service;

    @PostMapping("/register")
    public User register(@RequestBody UserDto dto)
    {
        return service.register(dto);
    }


    @PostMapping("/login")
    public String login(@RequestBody UserDto dto)
    {
        return  service.login(dto);
    }
}
