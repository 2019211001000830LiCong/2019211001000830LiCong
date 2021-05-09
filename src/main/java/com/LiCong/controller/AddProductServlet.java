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
    private static final Logger log = Logger.getLogger(AddProductServlet.class);

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
        String productname = request.getParameter("productname");
        Double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int categoryId = request.getParameter("categoryId") != null ? Integer.parseInt(request.getParameter("categoryId")) : 0;
        String producctDescription = request.getParameter("producctDescription");
        InputStream inputStream = null;
        Part filepart = request.getPart("picture");
        if (filepart != null) {
            System.out.println("file name :" + filepart.getName() + "  size" + filepart.getSize() + "  file type" + filepart.getContentType());
            inputStream = filepart.getInputStream();

        }
        Product product = new Product();
        product.setProductname(productname);
        ;
        product.setPrice(price);
        product.setProductDescription(producctDescription);
        product.setCategoryId(categoryId);


        ProductDao dao = new ProductDao();
        int i = 0;
        try {
            i = dao.save(product, inputStream, con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (i > 0) {
            response.sendRedirect("ProductList");//next calss
        }
    }
}