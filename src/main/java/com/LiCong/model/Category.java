package com.LiCong.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category implements java.io.Serializable{
    private int categoryId;
    private  String categoryname;
    private  String description;
    private Boolean active;
    public Category(){}
    public Category(String categoryname){
        this.categoryname=categoryname;
    }
    public Category(String categoryname ,String description,Boolean active){
        this.categoryname=categoryname;
        this.description=description;
        this.active=active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public static List<Category> findAllCategory(Connection con){
        List<Category> list=new ArrayList<Category>();
        String queryString ="select* from Category";
        try {
            PreparedStatement statement= con.prepareStatement(queryString);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Category c=new Category();
                c.setCategoryId(resultSet.getInt("categoryid"));;
                c.setCategoryname(resultSet.getString("categoryname"));
                c.setDescription(resultSet.getString("Description"));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public  static String findByCategoryId(Connection con,int categoryId){
        String categoryName=null;
        try {
            String queryString ="select CategoryName from Category where categoryId=?";
            PreparedStatement statement=con.prepareStatement(queryString);
            statement.setInt(1,categoryId);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                categoryName=resultSet.getString("categoryName");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryName;
    }
}
