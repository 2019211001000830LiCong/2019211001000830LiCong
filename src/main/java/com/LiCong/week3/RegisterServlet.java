package com.LiCong.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
        request.getRequestDispatcher("userList.jsp").forward(request,response);
        System.out.println("I an in RegisterServlet-->doPost()-->after forward()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");

        PrintWriter writer=response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>email:"+email);
        writer.println("<br>gender:"+gender);
        writer.println("<br>birthdate:"+birthdate);

        writer.close();
    }
}
