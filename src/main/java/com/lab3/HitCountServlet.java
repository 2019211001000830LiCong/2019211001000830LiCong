package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    private int hitCount;

    public void init() {
        hitCount = 0;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("contentType","text/html;charset=UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        //每当点击servlet时，此方法就会执行
        //增加hitCount
        hitCount++;
        PrintWriter out = response.getWriter();
        String title = "Total Number of Hits";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + ":</h1>\n" +
                "<h2 align = \"center\">" + hitCount + "</h2>\n" +
                "</body>\n" +
                "</html>"
        );
    }

    public void destroy() {
        //这是可选步骤，但是如果您愿意，可以在数据库中写入hitCount值。
    }

    //@Override
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   // }

    //@Override
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //}
}
