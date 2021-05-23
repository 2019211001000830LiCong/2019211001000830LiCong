package com.LiCong.controller;

import com.LiCong.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/getImg")
public class GetImgServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType( "tcxt/html" ) ;
        ProductDao dao=new ProductDao();
        int id=0;
        if(request.getParameter("id" ) !=null){
            id=Integer.parseInt(request.getParameter("id"));
        }
        try{
            byte[] imgByte= new byte[0];
            imgByte = dao.getPictureById(id,con);
            if(imgByte!=null){
                response.setContentType("image/gif");
                OutputStream os=response.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
