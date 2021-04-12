package com.LiCong.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    Connection con=null;
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context=sce.getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
            try {
                Class.forName(driver);
                try {
                    con= DriverManager.getConnection(url,username,password);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("init()-->"+con);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        System.out.println("I an in contextInitialized()");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("I an in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");
    }
}
