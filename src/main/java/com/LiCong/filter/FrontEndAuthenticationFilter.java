package com.LiCong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*");
public class FrontEndAuthenticationFilter implements Filter {
    private HttpServletRequest httpServletRequest;
    private  static final String[] LoginRequiredURLs = {"/updateUser","/logout","/myCart"};
    public  void doFilter(ServletRequest request , ServletResponse response, FilterChain chain)
        throws IOException,ServletException{
        httpServletRequest=(HttpServletRequest) request;
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        if(path.startsWith("/admin/")){
            chain.doFilter(request,response);
            return;
        }
        HttpSession session = httpServletRequest.getSession(false);
        boolean isLoggedIn =(session!=null && session.getAttribute("userList")!=null);
        String loginURI =httpServletRequest.getContextPath()+"/login";
        boolean isLoggedRequest=httpServletRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage =httpServletRequest.getRequestURI().endsWith("login");
        if(isLoggedIn &&(isLoggedRequest||isLoginPage)){
            httpServletRequest.getRequestDispatcher("/").forward(request,response);
        }else if(!isLoggedIn&&isLoginRequired()){
            String loginPage="/login";
            RequestDispatcher dispatcher=httpServletRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        }else {
            chain.doFilter(request,response);
        }
    }
    private boolean isLoginRequired(){
        String requestURL =httpServletRequest.getRequestURI().toString();
        for(String loginReiredURl : LoginRequiredURLs){
            if(requestURL.contains(loginReiredURl)){
                return  true;
            }
        }
        return  false;
    }
    public void destroy(){}
    public  void init(FilterConfig fconfig ) throws ServletException{}
}
