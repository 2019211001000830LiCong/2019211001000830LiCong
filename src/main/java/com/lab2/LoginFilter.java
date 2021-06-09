package com.lab2;

import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp","/lab2/validation.jsp"})
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in LoginFilter --> init()");
    }

    public void destroy() {
        System.out.println("I am in LoginFilter --> destroy()");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in LoginFilter --> doFilter() -- request before chain");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getSession() != null && req.getSession().isNew()) {
            request.getRequestDispatcher("/lab2/welcome.jsp").forward(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + "/lab2/login.jsp");
        }
        chain.doFilter(req, resp);
        System.out.println("I am in LoginFilter --> doFilter() -- request after chain");
    }
}