package com.LiCong.week5;

import com.LiCong.dao.UserDao;
import com.LiCong.model.User;
import com.mysql.cj.protocol.Resultset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;
    @Override
    public void init() throws ServletException {

        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter out=response.getWriter();

        UserDao userDao = new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {
                if(request.getParameter("remeberMe").equals("1"))
                {
                    Cookie usernameCookie=new Cookie("cUserName",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie remeberMeCookie=new Cookie("cRemeberMe",request.getParameter("remeberMe"));

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    remeberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(remeberMeCookie);
                }
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
