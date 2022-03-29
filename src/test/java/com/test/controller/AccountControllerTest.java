package com.test.controller;

import com.revature.bankingapp.Account;
import com.revature.bankingapp.AccountController;
import com.revature.client.Client;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountPostgresDAO;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountControllerTest {
    private static AccountDAO dao = new AccountPostgresDAO();
    private static Account a1;

    @BeforeAll
    //@AfterAll
    static void DBresetTest(){
        dao.removeBankAccount(104);
    }

    @Test
    @Order(1)
    public void newAccountTest(){
        Account a = new Account(104, 1000,1000, 10900);
        dao.newAccount(a);
        AccountControllerTest.a1 =a;

        Assertions.assertEquals(a, a1);
    }

    @Test
    @Order(2)
    public void getAccountsTest(){

        ArrayList<Account> accList1 = dao.getAccounts();

        ArrayList<Account> accList = new ArrayList<Account>();
        for(Account n: accList1){
            accList.add(n);
        }
        Assertions.assertEquals(accList1, accList);
    }

    @Test
    @Order(3)
    public void getAccountTest(){
        ArrayList<Account> accList2 = dao.getAccount(104);
        ArrayList<Account> accList3 = new ArrayList<>();
        Assertions.assertNotEquals(accList3,accList2);
    }

    @Test
    @Order(4)
    public void updateClientTest(){
        /*Account c = new Client(110,"Jackie D. Chan");
        dao.updateBankAccount(a1.getId(), c);
        ArrayList<Account> Account = dao.getClientID(a1.getId());
        Assertions.assertEquals(c.toString(), clients.get(0).toString());*/
    }

    @Test
    @Order(5)
    public void removeBankAccount(){
        ArrayList c = dao.removeBankAccount(a1.getId());
        Assertions.assertEquals(null, c);
    }

}
