package com.revature.dao;

import com.revature.client.Client;

import java.util.ArrayList;

public interface ClientDAO {
    ArrayList<Client> selectAllClients();

    ArrayList<Client> newClient(Client c1);

    ArrayList<Client> updateClient(int id, Client c1);

    ArrayList<Client> deleteClient(int id);

    ArrayList<Client> getClientID(int id);
}
