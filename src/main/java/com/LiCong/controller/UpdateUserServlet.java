package com.LiCong.controller;

import com.LiCong.dao.UserDao;
import com.LiCong.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat formatter=new SimpleDateFormat();
        Connection con=null;
        User u=new User();
        UserDao userDao=new UserDao();
        String username=request.getParameter("username");
       int id=Integer.parseInt(request.getParameter("id"));
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String date=request.getParameter("birthdate");
        Date birthdate= null;
        try {
            birthdate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        u.setUsername(username);
        u.setId(id);
        u.setPassword(password);
        u.setEmail(email);
        u.setGender(gender);
        u.setBirthday(birthdate);
        try {
            userDao.updateUser(con,u);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}
