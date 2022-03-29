package com.revature.service;

import com.revature.client.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientService {
    List<Client> selectAllClients();

    List<Client> newClient(Client c1);

    List<Client> updateClient(int id, Client c1);

    List<Client> deleteClient(int id);

    List<Client> getClientID(int id);
}
