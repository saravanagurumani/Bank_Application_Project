package com.example.BankApplication.loan.service;

import com.example.BankApplication.loan.dto.ApplyLoanDTO;
import com.example.BankApplication.loan.enumclass.LoanStatus;
import com.example.BankApplication.loan.enumclass.LoanType;
import com.example.BankApplication.loan.models.Loan;
import com.example.BankApplication.loan.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService{

    private final LoanRepository loanRepository;

    @Override
    public String applyloan(ApplyLoanDTO applyLoanDTO) {
        Loan loan=new Loan();
        loan.setAccountNo(applyLoanDTO.getAccountNo());
//        loan.setAccountStatus(); //fetch data from account
        loan.setLoanType(applyLoanDTO.getLoanType());
        loan.setLoanAmount(applyLoanDTO.getLoanAmount());
        loan.setTenureMonths(applyLoanDTO.getTenureMonths());
        double interestRate = applyLoanDTO.getLoanType().getInterestRate();
        loan.setInterestRate(interestRate);
        double emi = calculateEmI(applyLoanDTO.getLoanAmount(),loan.getInterestRate(),applyLoanDTO.getTenureMonths());
        loan.setEmiAmount(emi);
        loan.setTotalPayableAmount(emi * applyLoanDTO.getTenureMonths());
        loan.setLoanStatus(LoanStatus.APPLIED);
        loan.setAppliedDate(LocalDate.now());
        loanRepository.save(loan);
        return "Loan applied successfully";
    }


    //calculate EMI
    public static double calculateEmI(double principal, double annualRate, int months) {

        double monthlyRate = annualRate / (12 * 100);

        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);

        return Math.round(emi * 100.0) / 100.0; // round to 2 decimals
    }
}
