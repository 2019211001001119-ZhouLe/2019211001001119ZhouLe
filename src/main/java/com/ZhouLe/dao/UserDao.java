package com.ZhouLe.dao;

import com.ZhouLe.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "INSERT INTO usertable (username,password,email,gender,birthdate) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', '" + user.getGender() + "', '" + user.getBirthdate() + "')";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "DELETE FROM usertable where id = "+user.getId();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "UPDATE usertable username = '"+user.getUsername()+"', password = '"+user.getPassword()+"', email ='"+user.getEmail()+"', gender ='"+user.getGender()+"', birthdate = "+user.getBirthdate();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "SELECT * FROM usertable where id ="+id;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        User user = null;
        if(rs.next()) {
            user = new User();
            user.setId(id);
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            return user;
        }
        else
            return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "SELECT * FROM usertable where username ='"+username+"' and password ='"+password+"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        User user = null;
        if(rs.next()) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            return user;
        }
        else
            return null;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "SELECT * FROM usertable where username ='"+username+"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List users = new ArrayList();
        int i = 0;
        User user = null;
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(username);
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            users.add(user);
            i++;
        }
        if(i!=0)
            return users;
        else
            return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "SELECT * FROM usertable where password ='"+password+"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List users = new ArrayList();
        int i = 0;
        User user = null;
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(password);
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            users.add(user);
            i++;
        }
        if(i!=0)
            return users;
        else
            return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "SELECT * FROM usertable where email ='"+email+"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List users = new ArrayList();
        int i = 0;
        User user = null;
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setEmail(email);
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            users.add(user);
            i++;
        }
        if(i!=0)
            return users;
        else
            return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "SELECT * FROM usertable where gender ='"+gender+"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List users = new ArrayList();
        int i = 0;
        User user = null;
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(gender);
            user.setBirthdate(rs.getDate("birthdate"));
            users.add(user);
            i++;
        }
        if(i!=0)
            return users;
        else
            return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "SELECT * FROM usertable where birthdate ="+birthDate;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List users = new ArrayList();
        int i = 0;
        User user = null;
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(birthDate);
            users.add(user);
            i++;
        }
        if(i!=0)
            return users;
        else
            return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "SELECT * FROM usertable";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List users = new ArrayList();
        int i = 0;
        User user = null;
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            users.add(user);
            i++;
        }
        if(i!=0)
            return users;
        else
            return null;
    }
}
