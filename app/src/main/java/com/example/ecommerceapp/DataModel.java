package com.example.ecommerceapp;

public class DataModel
{
    int id;
    String name;
    String uname;
    String email;

    public DataModel(int id, String name, String uname, String email) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
