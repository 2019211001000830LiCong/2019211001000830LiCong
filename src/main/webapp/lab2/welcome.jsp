<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome,
    <jsp:useBean id="user" class="com.lab2.Login"></jsp:useBean>
    <jsp:setProperty property="username" name="user"/>
    <jsp:getProperty property="username" name="user"/>
    <% String name= user.getUsername();
    %>

    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
    
    <%--todo 10 : use jsp:getProperty to display username --%>
    
</h2>
</body>
</html>
