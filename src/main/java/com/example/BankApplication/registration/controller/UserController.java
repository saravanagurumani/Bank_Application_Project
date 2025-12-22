package com.example.BankApplication.registration.controller;

import com.example.BankApplication.registration.dto.ChangePasswordDto;
import com.example.BankApplication.registration.dto.UserDto;
import com.example.BankApplication.registration.models.User;
import com.example.BankApplication.registration.service.UserServiceInter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private UserServiceInter service;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto dto) {
        User user = service.register(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    // LOGOUT
    @DeleteMapping("/logout/{id}")
    public ResponseEntity<String> logout(@PathVariable Integer id) {
        return ResponseEntity.ok(service.logout(id));
    }

    // CHANGE PASSWORD
    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @Valid @RequestBody ChangePasswordDto dto) {

        return ResponseEntity.ok(service.changePassword(dto));
    }

    // GET PROFILE
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getProfile(
            @RequestParam String userName) {

        return ResponseEntity.ok(service.getProfile(userName));
    }

    // UPDATE PROFILE
    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(
            @Valid @RequestBody UserDto dto) {

        return ResponseEntity.ok(service.updateProfile(dto));
    }
}
