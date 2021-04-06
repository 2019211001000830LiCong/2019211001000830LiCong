<%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/5
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
This is my JSP page<br>
<form method="post" action="register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gender">Male <input type="radio" name="gender">Female<br/>
    Birthdate<input type="text name=" name="birthdate"><br/>
    <input type="submit" value="register"/>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
