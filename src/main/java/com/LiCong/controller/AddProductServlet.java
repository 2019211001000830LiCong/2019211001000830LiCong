package com.LiCong.controller;

import com.LiCong.dao.ProductDao;
import com.LiCong.model.Category;
import com.LiCong.model.Product;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    private Connection con = null;
    private static final Logger log = Logger.getLogger(String.valueOf(AddProductServlet.class));

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);
        String path = "/WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        Double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int categoryId = request.getParameter("categoryId") != null ? Integer.parseInt(request.getParameter("categoryId")) : 0;
        String productDescription = request.getParameter("productDescription");
        InputStream inputStream = null;
        Part filePart = request.getPart("picture");
        if (filePart != null) {
            System.out.println("file name :" + filePart.getName() + " size" + filePart.getSize() + "file type" + filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        product.setPicture(String.valueOf(inputStream));

        ProductDao dao = new ProductDao();
        int i = 0;
        try {
            i = dao.save(product, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0) {

        }
    }
}