package com.example.BankApplication.account.service;

import com.example.BankApplication.account.dto.AccountDTO;
import com.example.BankApplication.account.model.Account;

public interface AccountServiceInterface {


     Account viewAccountDetails(Integer id);
     String closeAccount(Integer id);
     Double viewBalance(Integer id);

    String createAccount(Integer id, AccountDTO accountDTO);
}
