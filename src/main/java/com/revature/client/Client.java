package com.revature.client;

public class Client {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    int id;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                '}';
    }

    String fname;

    public Client() {
    }

    public Client(int id, String fname) {
        this.id = id;
        this.fname = fname;
    }


}
