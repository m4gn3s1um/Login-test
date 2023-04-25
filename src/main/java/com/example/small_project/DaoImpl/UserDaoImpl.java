package com.example.small_project.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.small_project.Dao.UserDao;
import com.example.small_project.Model.User;

public class UserDaoImpl implements UserDao {

    private Connection con;

    public UserDaoImpl() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BI4ROKK;database=LoginCredentials;userName=sa;password=12345;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
        }
    }

    @Override
    public void createUser(String s1, String s2, int i1) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Login VALUES (?,?,?);");
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setInt(3, i1);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean loginExists(String s1, String s2) throws SQLException {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Login WHERE username = ? AND password = ?");
        ps.setString(1, s1);
        ps.setString(2, s2);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean adminExists(String s1, String s2) throws SQLException {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Login WHERE username = ? AND password = ? AND adminKey = 1");
        ps.setString(1, s1);
        ps.setString(2, s2);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<User> userList() {
    List<User> showAllUsers = new ArrayList<>();

    try
    {
        PreparedStatement ps = con.prepareStatement("Select * FROM Login");
        ResultSet rs = ps.executeQuery();

        User us;
        while(rs.next())
        {
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            int admin = rs.getInt(4);

            us = new User(id,username,password,admin);
            showAllUsers.add(us);
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

        return showAllUsers;
    }

    @Override
    public void promoteAdmin(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Login SET adminKey = 1 WHERE loginID = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
