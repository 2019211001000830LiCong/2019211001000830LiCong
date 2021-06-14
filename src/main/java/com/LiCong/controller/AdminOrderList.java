package com.LiCong.controller;

import com.LiCong.dao.OrderDao;
import com.LiCong.model.Order;
import com.LiCong.model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AdminOrderList", value = "/admin/orderList")
public class AdminOrderList extends HttpServlet {
    private Connection con=null;
    public void destroy(){
        super.destroy();
    }
    public void init() throws ServletException{
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypeList=Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypeList);
        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
        String path="/WEB-INF/views/admin/orderList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}