package com.revature.dao;

import com.revature.client.Client;
import com.revature.exceptions.InvalidUpdateException;
import com.revature.jdbc.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientPostgresDAO implements ClientDAO {
    Connection conn = ConnectionUtils.createConnection();
    PreparedStatement pstmt;
    ResultSet rs;
    ArrayList<Client> clList = new ArrayList<Client>();
    Client c;
    @Override
    public ArrayList<Client> selectAllClients() {
        String allClients = "select * from clients";
        try{
            pstmt = conn.prepareStatement(allClients);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("client_id");
                String fullName = rs.getString("full_name");
                c = new Client(id,fullName);
                clList.add(c);
            }
            rs.close();
            pstmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clList;
    }

    @Override
    public ArrayList<Client> newClient(Client c1) {
        String insert = "insert into clients values(?,?)";
        try {
            pstmt = conn.prepareStatement(insert);
            pstmt.setInt(1,c1.getId());
            pstmt.setString(2,c1.getFname());
            pstmt.execute();
            //c1=new Client();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Client> updateClient(int id, Client c1) {
        /*if(!(clList.equals(clList.isEmpty()))){
            clList.remove(c);
        }*/
        try {
            pstmt = conn.prepareStatement("update clients set full_name=? where client_id=?");
            pstmt.setInt(2,id);
            pstmt.setString(1,c1.getFname());
            pstmt.execute();
            clList = new ArrayList<>();
            clList.add(c1);
            //return clList;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    @Override
    public ArrayList<Client> deleteClient(int id) {
        try {
            pstmt = conn.prepareStatement("delete from clients where client_id=?");
            pstmt.setInt(1,id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Client> getClientID(int id) {
        ArrayList<Client> clList2 = new ArrayList<Client>();

        if(!(clList2.equals(clList2.isEmpty()))){
            clList2.remove(c);
        }
        String selectclient= "select * from clients where client_id=?";

        try{
            pstmt = conn.prepareStatement(selectclient);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while(rs.next()){

                int cid = rs.getInt("client_id");
                String name = rs.getString("full_name");
                c = new Client(cid, name);
                clList2.add(c);
            }
            rs.close();
            pstmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clList2;
    }
}
