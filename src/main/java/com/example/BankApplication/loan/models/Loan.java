package com.example.BankApplication.loan.models;

import com.example.BankApplication.account.model.AccountStatus;
import com.example.BankApplication.loan.enumclass.LoanStatus;
import com.example.BankApplication.loan.enumclass.LoanType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {

    //loan module
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private Long accountNo;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;   // ACTIVATE, DEACTIVATE

    //Loan Details (User Inputs)
    @Enumerated(EnumType.STRING)
    private LoanType loanType;  // EDUCATION, HOME, PERSONAL, ETC..
    private Double loanAmount;
    private Integer tenureMonths;


    //Calculated by System
    private Double interestRate;
    private Double emiAmount;
    private Double totalPayableAmount;

    //Loan Lifecycle
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus; // APPLIED, APPROVED, REJECTED, CLOSED
    private LocalDate appliedDate;
//    private LocalDate approvedDate;

//    private String message;

}
