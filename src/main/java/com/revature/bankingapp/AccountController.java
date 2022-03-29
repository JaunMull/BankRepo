package com.revature.bankingapp;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountPostgresDAO;
import com.revature.exceptions.InvalidUpdateException;
import com.revature.jdbc.ConnectionUtils;
import com.revature.service.AccountPostgresService;
import com.revature.service.AccountService;
import io.javalin.http.Handler;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountController {

    static AccountDAO dao= new AccountPostgresDAO();
    static AccountService service = new AccountPostgresService();
    static List<Account> accList;
    public static Handler getAccounts=ctx->{

        List<Account> accList= service.getAccounts();
        ctx.status(200);
        ctx.json(accList);

    };

    public static Handler newAccount = ctx->{
        Account a1 = ctx.bodyAsClass(Account.class);
        List<Account> accList= service.newAccount(a1);
        ctx.status(201);
        //ctx.json(accList+" Has been added to the database");

    };

    public static Handler updateBankAccount=ctx-> {
        try{
            int id = Integer.parseInt(ctx.pathParam("cid"));
            Account a1 = ctx.bodyAsClass(Account.class);
            Account a = service.updateBankAccount(id, a1);
            ctx.json(a);
        }catch (NullPointerException i){
            ctx.status(404);
            ctx.json("Error 404: Not Found");
        }



    };

    public static Handler removeBankAccount=ctx->{
        try{
            int id = Integer.parseInt(ctx.pathParam("cid"));
            accList= service.removeBankAccount(id);
            ctx.json(accList);
        }catch (NullPointerException n){
            ctx.status(404);
            ctx.json("Error 404: Not Found");
        }

    };

    public static Handler getAccount=ctx->{
        int cid = Integer.parseInt(ctx.pathParam("cid"));
        List<Account> accList = service.getAccount(cid);
        if(accList.size() == 0){
            ctx.status(404);
            ctx.json("Error 404: Not Found");
        }else{
            ctx.json(accList);
        }


    };

}
