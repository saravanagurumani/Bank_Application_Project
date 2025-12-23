package com.example.BankApplication.registration.service;

import com.example.BankApplication.registration.dto.ChangePasswordDto;
import com.example.BankApplication.registration.dto.UserDto;
import com.example.BankApplication.registration.models.User;
import com.example.BankApplication.registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
        user.setMobileNum(dto.getMobileNum());
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

     public String logout(Integer id)
     {
        User user= userRepository.findById(id).orElseThrow(() ->new RuntimeException("Invalid Id"));
        userRepository.delete(user);

        return  "Logout";
     }

     public String changePassword(ChangePasswordDto dto)
     {
         User user = userRepository.findByUserName(dto.getUserName());


         if (user == null) {
             throw new RuntimeException("User not found");
         }

         // Verify old password
         if (!user.getPassword().equals(dto.getOldPassword())) {
             throw new RuntimeException("Old password is incorrect");
         }

         user.setPassword(dto.getNewPassword());
         userRepository.save(user);

         return "Password changed successfully";
     }

    public Map<String, Object> getProfile(String userName) {

        User user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Map<String, Object> profile = new HashMap<>();
        profile.put("firstName", user.getFirstName());
        profile.put("lastName", user.getLastName());
        profile.put("email", user.getEmail());
        profile.put("mobileNum", user.getMobileNum());
        profile.put("DOB", user.getDOB());
        profile.put("regDate", user.getRegDate());

        return profile;
    }


    public String updateProfile(UserDto dto) {

        User user = userRepository.findByUserName(dto.getUserName());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setMobileNum(dto.getMobileNum());
        user.setDOB(dto.getDOB());

        userRepository.save(user);
        return "Profile updated successfully";
    }

}
