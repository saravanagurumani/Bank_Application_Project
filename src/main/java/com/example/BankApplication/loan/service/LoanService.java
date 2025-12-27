package com.example.BankApplication.loan.service;

import com.example.BankApplication.loan.dto.ApplyLoanDTO;
import org.springframework.stereotype.Service;

public interface LoanService {
    String applyloan(ApplyLoanDTO applyLoanDTO);
}
