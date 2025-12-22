package com.example.BankApplication.registration.service;

import com.example.BankApplication.registration.dto.UserDto;
import com.example.BankApplication.registration.models.User;
import com.example.BankApplication.registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService
{
    private UserRepository userRepository;

    public User register(UserDto dto) {

        if (userRepository.existsByUserName(dto.getUserName())) {
            throw new RuntimeException("Username already registered");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDOB(dto.getDOB());
        user.setEmail(dto.getEmail());
        user.setMobileNum(Long.parseLong(dto.getMobileNum()));
        user.setRegDate(LocalDateTime.now());

        return userRepository.save(user);
    }


    public String login(UserDto dto)
    {

        User user = userRepository.findByUserName(dto.getUserName());

        if (user == null) {
            throw new RuntimeException("User not registered");
        }

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login Successfully........";

    }


}
