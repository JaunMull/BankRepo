package com.test.controller;

import com.revature.client.Client;
import com.revature.dao.ClientDAO;
import com.revature.dao.ClientPostgresDAO;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HandControllerTest {
    private static ClientDAO dao= new ClientPostgresDAO();
    private static Client c1;

    @BeforeAll
    //@AfterAll
    static void DBresetTest(){
        dao.deleteClient(110);
    }

    @Test
    @Order(1)
    public void newClientTest(){
        Client c = new Client(110,"Curious George");
        dao.newClient(c);
        HandControllerTest.c1 =c;

        Assertions.assertEquals(110, c1.getId());
        Assertions.assertEquals("Curious George",c1.getFname());

    }

    /*public void sadnewClient(){

    }*/
    @Test
    @Order(2)
    public void selectAllClientsTest(){

        ArrayList<Client> cList1 = dao.selectAllClients();

        ArrayList<Client> cList = new ArrayList<Client>();
        for(Client n: cList1){
            cList.add(n);
        }
        Assertions.assertEquals(cList1, cList);
    }

    @Test
    @Order(3)
    public void getClientIDTest(){
        ArrayList<Client> cList = dao.getClientID(110);
        Assertions.assertEquals("Curious George",c1.getFname());
    }
    @Test
    @Order(4)
    public void updateClientTest(){
        Client c = new Client(110,"Jackie D. Chan");
        dao.updateClient(c1.getId(), c);
        ArrayList<Client> clients = dao.getClientID(c1.getId());
        Assertions.assertEquals(c.toString(), clients.get(0).toString());
    }

    @Test
    @Order(5)
    public void deleteClient(){
        ArrayList c = dao.deleteClient(c1.getId());
        Assertions.assertEquals(null, c);
    }

}
