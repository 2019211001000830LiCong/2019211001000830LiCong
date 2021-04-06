package com.LiCong.week3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("I am in constructor -->LifeCycleServlet()");
    }

    @Override
    public void init(){
        System.out.println("I am in init()");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I an in service()  -->doGet() ");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("I am in destroy()");
    }
}
