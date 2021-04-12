package com.LiCong.week5;

import com.mysql.cj.protocol.Resultset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select id,username,password,email,gender,birthdate from usertable where username='";
        try {
            Resultset rs = (Resultset) con.createStatement().executeQuery(sql);
            if (rs.next()) {
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthdate", rs.getString("birthdate"));
                request.getRequestDispatcher("userlist.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
