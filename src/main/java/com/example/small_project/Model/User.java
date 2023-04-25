package com.example.small_project.Model;

public class User {

    private int id;

    private String username;

    private String password;

    private int admin;


    public User(int id, String username, String password, int admin){
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAdmin(){return admin;}

    @Override
    public String toString() {
        return "Username: " + username + " " + "Password: " + password + " " + "Admin: " + admin;
    }
}
