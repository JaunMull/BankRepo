package com.revature.dao;

import com.revature.bankingapp.Account;
import com.revature.client.Client;
import com.revature.jdbc.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountPostgresDAO implements AccountDAO{
    Connection conn = ConnectionUtils.createConnection();
    PreparedStatement pstmt;
    ResultSet rs;
    Account a;
    ArrayList<Account> accList = new ArrayList<Account>();

    @Override
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accList = new ArrayList<Account>();
        Account a;
        String AllAccounts = "select * from BankingAccounts";

        try{
            pstmt = conn.prepareStatement(AllAccounts);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("cid");
                int checkAcc = rs.getInt("checkingacc");
                int saveAcc = rs.getInt("savingacc");
                int accNum = rs.getInt("accnum");
                a = new Account(id, checkAcc, saveAcc, accNum);
                accList.add(a);
            }
            rs.close();
            pstmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return accList;
    }

    @Override
    public ArrayList<Account> newAccount(Account a1 ) {
        String newAcc = "insert into BankingAccounts (checkingacc,savingacc,cid) values (?,?,?)";
        try{
            pstmt = conn.prepareStatement(newAcc);

            pstmt.setInt(1,a1.checkAcc);
            pstmt.setInt(2,a1.savAcc);
            pstmt.setInt(3,a1.id);
            //pstmt.setInt(4,a1.accNum);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account updateBankAccount(int id,Account a1) {
        String updateAcc = "update BankingAccounts set checkingacc=?,savingacc=? where cid=? ";
        try {
            pstmt = conn.prepareStatement(updateAcc);
            pstmt.setInt(1, a1.getCheckAcc());
            pstmt.setInt(2,a1.getSavAcc());
            pstmt.setInt(3, id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a1;
    }

    @Override
    public ArrayList<Account> removeBankAccount(int id) {
        try{
            pstmt = conn.prepareStatement("delete from bankingAccounts where cid=?");
            pstmt.setInt(1,id);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Account> getAccount(int cid) {
        ArrayList<Account> accList2 = new ArrayList<Account>();

        if(!(accList2.equals(accList2.isEmpty()))){
            accList2.remove(a);
        }

        String account = "select * from bankingAccounts where cid=?";

        try{
            pstmt = conn.prepareStatement(account);
            pstmt.setInt(1,cid);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("cid");
                int checkAcc = rs.getInt("checkingacc");
                int saveAcc = rs.getInt("savingacc");
                int accNum = rs.getInt("accnum");
                a = new Account(id, checkAcc, saveAcc, accNum);
                accList2.add(a);

            }
            rs.close();
            pstmt.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return accList2;
    }
}
