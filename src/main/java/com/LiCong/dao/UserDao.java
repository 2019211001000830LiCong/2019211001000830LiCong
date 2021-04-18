package com.LiCong.dao;

import com.LiCong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?);";
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setString(4,user.getEmail());
        preparedStatement.setString(5,user.getGender());
        preparedStatement.setDate(6, (java.sql.Date) user.getBirthday());

        int result = preparedStatement.executeUpdate();
        return result==1?true:false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable where id=?;";
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setInt(1,user.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthday=? where id=?;";
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getGender());
        preparedStatement.setDate(5, (java.sql.Date) user.getBirthday());
        preparedStatement.setInt(6,user.getId());

        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from usertable where id=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        if(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from usertable where username=? and password=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet rs=preparedStatement.executeQuery();
        User user=null;
        if(rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> userList=new ArrayList<User>();

        String sql="select * from usertable where username=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> userList=new ArrayList<User>();

        String sql="select * from usertable where password=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,password);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> userList=new ArrayList<User>();

        String sql="select * from usertable where email=?";
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> userList=new ArrayList<User>();

        String sql="select * from usertable where gender=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,gender);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> userList=new ArrayList<User>();

        String sql="select * from usertable where birthday=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> userList=new ArrayList<User>();

        String sql="select * from usertable";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();
        User user=new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        return userList;
    }
}
