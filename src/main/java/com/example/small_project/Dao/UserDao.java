package com.example.small_project.Dao;

import com.example.small_project.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public void createUser(String s1, String s2, int i1) throws SQLException;

    public boolean loginExists(String s1, String s2) throws SQLException;

    public boolean adminExists(String s1, String s2) throws SQLException;

    public List<User> userList();

    public void promoteAdmin(int id);

}
