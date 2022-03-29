package com.revature.client;

import com.revature.bankingapp.AccountController;
import com.revature.bankingapp.SubAccountController;
import com.revature.controller.HandController;
import io.javalin.Javalin;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientManager {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.get("/clients", HandController.selectAllClients);

        app.get("/clients/accounts", AccountController.getAccounts);

        app.get("/clients/accounts/{cid}", AccountController.getAccount);

        app.post("/clientsinfo", HandController.newClient);

        app.post("/clientinfo/newaccount", AccountController.newAccount);

        app.put("/clientsinfo/{id}", HandController.updateClient);

        app.put("/clients/accounts/{cid}", AccountController.updateBankAccount);

        app.delete("/clientsinfo/{id}", HandController.deleteClient);

        app.delete("/clientinfo/{cid}/account", AccountController.removeBankAccount);

        app.get("/clients/{id}", HandController.getClientID);

        app.put("/clients/{id}/deposit/check", SubAccountController.DepositCheck);

        app.put("/clients/{id}/deposit/save", SubAccountController.DepositSave);

        app.put("/clients/{id}/withdraw/check", SubAccountController.WithdrawCheck);

        app.put("/clients/{id}/withdraw/save", SubAccountController.WithdrawSave);

    }

}
