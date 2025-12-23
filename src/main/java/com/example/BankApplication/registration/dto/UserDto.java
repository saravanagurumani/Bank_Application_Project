package com.example.BankApplication.registration.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    @NotBlank(message = "Username should not be blank")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$",
            message = "Invalid username format"
    )
    private String userName;

    @Size(min=6 , max = 12, message = "Min is 6 and Max is 12")
    private String password;

    @NotBlank(message = "Name Should not be null")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Date of Birth must be given")
    private String DOB;

    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number must be a valid 10-digit Indian number"
    )
    private long mobileNum;

    private LocalDateTime regDate;
}
