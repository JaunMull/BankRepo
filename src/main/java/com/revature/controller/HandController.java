package com.revature.controller;

import com.revature.client.Client;
import com.revature.dao.ClientDAO;
import com.revature.dao.ClientPostgresDAO;
import com.revature.exceptions.InvalidUpdateException;
import com.revature.jdbc.ConnectionUtils;
import com.revature.service.ClientPostgresService;
import com.revature.service.ClientService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HandController {
    static Client c;
    //static List<Client> clList;

    static ClientDAO dao = new ClientPostgresDAO();
    static ClientService service = new ClientPostgresService();

    public static Handler selectAllClients = ctx -> {
        List<Client> clList = service.selectAllClients();
        ctx.status(200);
        ctx.json(clList);

    };

    public static Handler newClient = ctx->{

        Client c1 = ctx.bodyAsClass(Client.class);
        List<Client> clientList = service.newClient(c1);
        ctx.status(201);

    };

    public static Handler updateClient = ctx->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Client c1 = ctx.bodyAsClass(Client.class);
        try{
            List<Client> clList = service.updateClient(id,c1);
            ctx.json(clList);
            //ctx.status(205);
        }catch (NullPointerException i){
            ctx.status(404);
            ctx.json("Error 404: Not Found");
        }
            /*if(String.valueOf(clList).equals("null")){
                ctx.status(404);
                ctx.result("Error code: 404. Not Found");
            }else{
                ctx.status(205);
            }*/
    };

    public static Handler deleteClient = ctx->{

        try{
            int id = Integer.parseInt(ctx.pathParam("id"));
            List<Client> clList = service.deleteClient(id);
            ctx.json(clList);
        }catch (NullPointerException n){
            ctx.status(404);
            ctx.json("Error 404: Not Found");
        }

        /*if(id == 0){
            ctx.status(404);
        }else{
            ctx.status(200);
        }*/
    };

    public static Handler getClientID = ctx->{


          int id = Integer.parseInt(ctx.pathParam("id"));
          List<Client> clList = service.getClientID(id);
          if(clList.size() == 0){
              ctx.status(404);
              ctx.json("Error 404: Not Found");
          }else{
              ctx.json(clList);
          }





    };

}
