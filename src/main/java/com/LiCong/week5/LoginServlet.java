package com.LiCong.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{

    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response){

    }
    @Override
    protected  void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
