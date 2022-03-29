package com.revature.service;

import com.revature.bankingapp.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    List<Account> newAccount(Account a1);

    Account updateBankAccount(int id,Account a1);

    List<Account> removeBankAccount(int id);

    List<Account> getAccount(int cid);
}
