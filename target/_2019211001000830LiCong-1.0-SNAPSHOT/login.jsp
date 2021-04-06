<%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/6
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
Login<br>
<br/>
<form method="post" action="login">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
