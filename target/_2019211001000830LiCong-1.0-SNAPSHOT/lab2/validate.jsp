<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<jsp:useBean id="user" class="com.lab2.Login"></jsp:useBean>
<jsp:setProperty property="username" name="user"/>
<jsp:setProperty property="password" name="user"/>


<jsp:getProperty property="username" name="user"/>
<jsp:getProperty property="password" name="user"/>
<%
    if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
        session.setAttribute("username", user.getUsername());
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }else{
       /// System.out.println("Username Password Error");
        response.sendRedirect("login.jsp");
    }
%>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>

    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<%
   //todo 3: use if check username is admin and ppassword is admin
%>
    <%--todo 4: use jsp:forward to welcome.jsp page--%>

    <%--todo 5: else part{ --%>

<%
// todo 6: print username or password error message

%>
    <%--todo 7: use jsp:include login.jsp page --%>

    <%--todo 8: close else --%>

</body>
</html>