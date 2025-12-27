package com.example.BankApplication.account.service;

import com.example.BankApplication.account.dto.AccountDTO;
import com.example.BankApplication.account.model.Account;
import com.example.BankApplication.account.repository.AccountRepository;
import com.example.BankApplication.registration.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService implements AccountServiceInterface {

//    private AccountServiceInterface accountServiceInterface;
    private AccountRepository accountRepository;
    @Override
    public String createAccount(Integer id, AccountDTO accountDTO) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("This account doesn't exist"));
        account.setAadharNo(accountDTO.getAadharNo());
        account.setPanNo(accountDTO.getPanNo());

        return "";
    }


    @Override
    public Account viewAccountDetails(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("This account doesn't exist"));
        return account;
    }

    @Override
    public String closeAccount(Integer id) {
        Account account = accountRepository.findById(id)
            .orElseThrow(()->new RuntimeException("This account doesn't exist"));
        accountRepository.delete(account);
        return "Account Closed Successfully";
    }

    @Override
    public Double viewBalance(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("This account doesn't exist"));
        return account.getBalance();

    }




}
