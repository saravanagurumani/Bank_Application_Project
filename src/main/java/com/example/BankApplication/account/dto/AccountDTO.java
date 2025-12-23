package com.example.BankApplication.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Integer accNo;
    @NotBlank(message = "Aaadhar number is mandatory")
    @Pattern(
            regexp = "^[2-9][0-9]{11}$",
            message = "Invalid Aadhaar number")
    private Long aadharNo;
    @NotBlank(message = "PAN number is mandatory")
    @Pattern(
            regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$",
            message = "Invalid PAN number")
    private String panNo;
}
