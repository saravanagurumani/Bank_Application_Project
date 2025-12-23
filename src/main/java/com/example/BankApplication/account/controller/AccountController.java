package com.example.BankApplication.account.controller;

import com.example.BankApplication.account.dto.AccountDTO;
import com.example.BankApplication.account.model.Account;
import com.example.BankApplication.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

   private AccountService accountService;

    @PostMapping("/account/{id}")
    public String createAccount(@PathVariable Integer id, AccountDTO accountDTO) {

        return accountService.createAccount(id, accountDTO);
    }

    @GetMapping("/account/{id}")
    public Account viewAccountDetails(@PathVariable Integer id) {
        Account account =  accountService.viewAccountDetails(id);
        return account;
    }


    public String closeAccount(@PathVariable Integer id) {
        return accountService.closeAccount(id);
    }


    public Double viewBalance(@PathVariable Integer id) {
        return accountService.viewBalance(id);
    }
}
