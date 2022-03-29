package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement {
    public void DBconnect(){
        java.sql.PreparedStatement pstmt;
        ResultSet rs;

        Connection conn = ConnectionUtils.createConnection();
        String selectAllClient= "select * from client";
        String selectOneClient= "select * from client where id=?";
        try{
            pstmt=conn.prepareStatement(selectAllClient);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                //System.out.println(rs.getInt("id") +  "  " + rs.getString("name"));
                System.out.println(rs.getInt(1) +  "  " + rs.getString("client_name"));
            }
            rs.close();
            pstmt.close();

            System.out.println("===================================");
            pstmt = conn.prepareStatement(selectOneClient);
            pstmt.setInt(1,12);
            rs=pstmt.executeQuery();
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString("client_name"));

            rs.close();
            pstmt.close();
            System.out.println("=========== Insert Data to Table ============");
            String insertClient="insert into client values(?,?)";
            pstmt= conn.prepareStatement(insertClient);
            pstmt.setInt(1,18);
            pstmt.setString(2,"Derek");
            pstmt.executeUpdate();

            rs.close();
            pstmt.close();
            System.out.println("=========== Update Data to Table ============");
            String updateClient="Update client set client_name =? where id=?";
            pstmt= conn.prepareStatement(updateClient);
            pstmt.setInt(2,12);
            pstmt.setString(1,"Jasdhir");
            pstmt.executeUpdate();


        }catch (SQLException e){

            e.printStackTrace();
        }
    }

}
