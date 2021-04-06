package com.LiCong.week4;

import com.mysql.cj.protocol.Resultset;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCServlet extends HttpServlet {
    Connection con=null;
    public  void init() throws ServletException {
        ServletConfig config=getServletConfig();
        String driver= config.getInitParameter("driver");
        String url= config.getInitParameter("url");
        String username= config.getInitParameter("username");
        String password= config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("i am in init");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet");
        String sql="select * from usertable";
        ResultSet resultSet= null;
        try {
            resultSet = con.createStatement().executeQuery(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        try{
            while(true){
                assert resultSet != null;
                if (!resultSet.next()) break;
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String password=resultSet.getString(3);
                String email=resultSet.getString(4);
                String gender=resultSet.getString(5);
                String birthdate=resultSet.getString(6);
                System.out.println("id"+id);
                System.out.println("name"+name);
                System.out.println("password"+password);
                System.out.println("email"+email);
                System.out.println("gender"+gender);
                System.out.println("birthdate"+birthdate);

            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql="insert into usertable(1,'LiCong','123456','Male','858211645@qq.com','Male','2012-12-12')";
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            if(con!=null) {
                con.close();
                con =null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
