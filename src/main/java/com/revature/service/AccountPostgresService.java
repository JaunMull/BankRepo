package com.revature.service;

import com.revature.bankingapp.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountPostgresDAO;

import java.util.List;

public class AccountPostgresService implements AccountService{
    AccountDAO dao= new AccountPostgresDAO();

    @Override
    public List<Account> getAccounts() {
        return dao.getAccounts();
    }

    @Override
    public List<Account> newAccount(Account a1) {
        return dao.newAccount(a1);
    }

    @Override
    public Account updateBankAccount(int id,Account a1) {
        return dao.updateBankAccount( id, a1);
    }

    //@Override
    //public List<Account> updateBankAccount() {
     //   return ;
    //}

    @Override
    public List<Account> removeBankAccount(int id) {
        return dao.removeBankAccount(id);
    }

    @Override
    public List<Account> getAccount(int cid) {
        return dao.getAccount( cid);
    }
}
