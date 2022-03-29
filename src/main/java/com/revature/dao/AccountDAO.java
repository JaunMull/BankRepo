package com.revature.dao;

import com.revature.bankingapp.Account;

import java.util.ArrayList;

public interface AccountDAO {
    ArrayList<Account> getAccounts();

    ArrayList<Account> newAccount(Account a1);

    Account updateBankAccount(int id,Account a1);

    ArrayList<Account> removeBankAccount(int id);

    ArrayList<Account> getAccount(int cid);
}
