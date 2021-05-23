package com.LiCong.controller;

import com.LiCong.dao.ProductDao;
import com.LiCong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/admin/productlist")
public class ProductListServlet extends HttpServlet {
    Connection con=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao productDao=new ProductDao();
            List<Product> products=productDao.findAll(con);
            request.setAttribute("products",products);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="/WEB-INF/views/admin/productlist.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
