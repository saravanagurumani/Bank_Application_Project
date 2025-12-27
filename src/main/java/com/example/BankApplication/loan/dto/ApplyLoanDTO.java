package com.example.BankApplication.loan.dto;

import com.example.BankApplication.loan.enumclass.LoanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyLoanDTO {

    private Long accountNo;
    private LoanType loanType;
    private Double loanAmount;
    private Integer tenureMonths;

}
