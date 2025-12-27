package com.example.BankApplication.loan.controller;

import com.example.BankApplication.loan.dto.ApplyLoanDTO;
import com.example.BankApplication.loan.service.LoanServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanServiceImpl loanService;

    @PostMapping("/applyloan")
    public String ApplyLoan(@RequestBody ApplyLoanDTO applyLoan){
        return loanService.applyloan(applyLoan);
    }
}
