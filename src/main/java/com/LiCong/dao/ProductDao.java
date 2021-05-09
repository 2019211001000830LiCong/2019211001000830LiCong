package com.LiCong.dao;

import com.LiCong.model.Category;
import com.LiCong.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if (product.getPicture() != null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        String sql = "delete from productable where id=?;";
        int result = 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, Product.getProductId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Product instance, Connection con) {
        String sql = "update productable set username=?,password=?,email=?,gender=?,birthday=? where id=?;";
        int result = 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, instance.getUsername());
            preparedStatement.setString(2, instance.getPassword());
            preparedStatement.setString(3, instance.getEmail());
            preparedStatement.setString(4, instance.getGender());
            result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Product findById(Integer productId, Connection con) {
        String sql="select * from productable where productId=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setInt(1,productId);
        ResultSet rs=preparedStatement.executeQuery();
        Product product=new Product();
        if(rs.next()) {
            product.setProductId(rs.getInt("id"));
            product.setProductname(rs.getString("username"));
            product.setPrice(rs.getString("password"));
            product.setProductDescription(rs.getString("email"));
            product.setPicture(rs.getString("gender"));
            product.setCategoryId(rs.getDate("birthday"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        List<Product> productList=new ArrayList<Product>();

        String sql="select * from productable where categoryId=?";
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,categoryId);
            ResultSet rs=preparedStatement.executeQuery();
            Product product=new Product();
            while(rs.next()) {
                product.setProductId(rs.getInt("id"));
                product.setProductname(rs.getString("username"));
                product.setPrice(rs.getString("password"));
                product.setProductDescription(rs.getString("email"));
                product.setPicture(rs.getString("gender"));
                product.setCategoryId(rs.getDate("birthday"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;

    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productsList=new ArrayList<Product>();

        String sql="select * from productable where username=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet rs=preparedStatement.executeQuery();
        Product product=new Product();
        while(rs.next()) {
            product.setProductId(rs.getInt("id"));
            product.setProductname(rs.getString("username"));
            product.setPrice(rs.getString("password"));
            product.setProductDescription(rs.getString("email"));
            product.setPicture(rs.getString("gender"));
            product.setCategoryId(rs.getDate("birthday"));
            productsList.add(product);
        }
        return productsList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productsList=new ArrayList<Product>();

        String sql="select * from productable ";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();
        Product product=new Product();
        while(rs.next()) {
            product.setProductId(rs.getInt("id"));
            product.setProductname(rs.getString("username"));
            product.setPrice(rs.getString("password"));
            product.setProductDescription(rs.getString("email"));
            product.setPicture(rs.getString("gender"));
            product.setCategoryId(rs.getDate("birthday"));
            productsList.add(product);
        }
        return productsList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> productsList=new ArrayList<Product>();

        String sql="select * from productable where productName=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,productName);
        ResultSet rs=preparedStatement.executeQuery();
        Product product=new Product();
        while(rs.next()) {
            product.setProductId(rs.getInt(""));
            product.setProductname(rs.getString("username"));
            product.setPrice(rs.getString("password"));
            product.setProductDescription(rs.getString("email"));
            product.setPicture(rs.getString("gender"));
            product.setCategoryId(rs.getDate("birthday"));
            productsList.add(product);
        }
        return productsList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> productsList=new ArrayList<Product>();

        String sql="select * from productable where productId=?";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,productId);
        ResultSet rs=preparedStatement.executeQuery();
        Product product=new Product();
        while(rs.next()) {
            product.setProductId(rs.getInt("id"));
            product.setProductname(rs.getString("username"));
            product.setPrice(rs.getString("password"));
            product.setProductDescription(rs.getString("email"));
            product.setPicture(rs.getString("gender"));
            product.setCategoryId(rs.getDate("birthday"));
            productsList.add(product);
        }
        return productsList;
    }
}
