package com.LiCong.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String type = request.getParameter("search");
        if (txt == null) response.sendRedirect("index.jsp");
        else {
            if (type.equals("baidu"))
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            else if (type.equals("bing"))
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            else if (type.equals("google"))
                response.sendRedirect("https://www.google.com/search?q=" + txt);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
