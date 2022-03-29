package com.revature.bankingapp;

import com.revature.jdbc.ConnectionUtils;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubAccountController {
    public static Handler DepositCheck = ctx-> {
        int id =Integer.parseInt(ctx.pathParam("id"));

        Account a1 = ctx.bodyAsClass(Account.class);

        Connection conn = ConnectionUtils.createConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        pstmt = conn.prepareStatement("select checkingacc from BankingAccounts where id=?");
        pstmt.setInt(1,id);
        rs = pstmt.executeQuery();
        try {


            int checking = 0;
            while(rs.next()){
                checking = rs.getInt("checkingacc");
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("update bankingAccounts set checkingacc=? where id=?");
            int upDep = checking + a1.getDeposit();
            pstmt.setInt(1,upDep);
            pstmt.setInt(2,id);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }


    };

    public static Handler WithdrawCheck = ctx-> {
        int id =Integer.parseInt(ctx.pathParam("id"));

        Account a1 = ctx.bodyAsClass(Account.class);

        Connection conn = ConnectionUtils.createConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        pstmt = conn.prepareStatement("select checkingacc from bankingAccounts where id=?");
        pstmt.setInt(1,id);
        rs = pstmt.executeQuery();
        try {


            int checking = 0;
            while(rs.next()){
                checking = rs.getInt("checkingacc");
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("update bankingAccounts set checkingacc=? where id=?");
            int upWith =  checking-a1.getWithdraw() ;
            pstmt.setInt(1,upWith);
            pstmt.setInt(2,id);
            if (upWith>0){

                pstmt.execute();
            }else{
                ctx.json("Cannot Withdraw that amount");
                ctx.json("your current Checking Account Balance is:" + checking);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


    };

    public static Handler DepositSave = ctx-> {
        int id =Integer.parseInt(ctx.pathParam("id"));

        Account a1 = ctx.bodyAsClass(Account.class);

        Connection conn = ConnectionUtils.createConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        pstmt = conn.prepareStatement("select savingacc from bankingAccounts where id=?");
        pstmt.setInt(1,id);
        rs = pstmt.executeQuery();
        try {

            int saving = 0;
            while(rs.next()){
                saving = rs.getInt("savingacc");
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("update bankingAccounts set savingacc=? where id=?");
            int upDep =a1.getDeposit() + saving;
            pstmt.setInt(1,upDep);
            pstmt.setInt(2,id);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }


    };
    public static Handler WithdrawSave = ctx-> {
        int id =Integer.parseInt(ctx.pathParam("id"));

        Account a1 = ctx.bodyAsClass(Account.class);

        Connection conn = ConnectionUtils.createConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        pstmt = conn.prepareStatement("select savingacc from bankingAccounts where id=?");
        pstmt.setInt(1,id);
        rs = pstmt.executeQuery();
        try {

            int saving = 0;
            while(rs.next()){
                saving = rs.getInt("savingacc");
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("update bankingAccounts set savingacc=? where id=?");
            int upWith = saving - a1.getWithdraw() ;
            pstmt.setInt(1,upWith);
            pstmt.setInt(2,id);

            if (upWith>0){

                pstmt.execute();
            }else{
                ctx.json("Cannot Withdraw that amount");
                ctx.json("your current Saving Account Balance is:" + saving);
            }



        }catch (SQLException e){
            e.printStackTrace();
        }


    };
}
