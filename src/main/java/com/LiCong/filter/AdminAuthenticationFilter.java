package com.LiCong.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import  java.io.IOException;
@WebFilter("/admin/*");
public class AdminAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        HttpSession session=httpServletRequest.getSession(false);
        boolean isLoggedIn =(session != null&& session.getAttribute("userList")!=null);
        String loginURI =httpServletRequest.getContextPath()+"/admin/login";
        boolean isLoginRequest =httpServletRequest.getRequestURI().equals(loginURI);
        boolean isloginPage =httpServletRequest.getRequestURI().endsWith("login");
        if(isLoggedIn&&(isLoginRequest || isloginPage))
        {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/admin/home");
            requestDispatcher.forward(request,response);
        }else if(isLoggedIn || isLoginRequest)
        {
            filterChain.doFilter(request,response);
        }else
        {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/login");
        }
    }
    @Override
    public void destroy() { }
    @Override
    public void  init(FilterConfig fconfig) throws ServletException{}
}
