package com.revature.service;

import com.revature.client.Client;
import com.revature.dao.ClientDAO;
import com.revature.dao.ClientPostgresDAO;

import java.util.List;

public class ClientPostgresService implements ClientService{
    ClientDAO dao = new ClientPostgresDAO();
    @Override
    public List<Client> selectAllClients() {
        return dao.selectAllClients();
    }

    @Override
    public List<Client> newClient(Client c1) {return dao.newClient( c1);}

    @Override
    public List<Client> updateClient(int id, Client c1) {return dao.updateClient(id, c1);}

    @Override
    public List<Client> deleteClient(int id) {return dao.deleteClient(id);}

    @Override
    public List<Client> getClientID(int id) {return dao.getClientID(id);}
}
