package com.LiCong.controller;

import com.LiCong.dao.ProductDao;
import com.LiCong.model.Category;
import com.LiCong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/productsDetails")
public class ProductsDetailsServlet extends HttpServlet {
    private Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=request.getParameter("id")!=null? Integer.parseInt(request.getParameter("id")):0;
        ProductDao productDao=new ProductDao();
        if(id==0){
            return;
        }
        List<Category>  categoryList=Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        Product product=productDao.findById(id,con);
        request.setAttribute("p",product);
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
