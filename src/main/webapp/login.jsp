<%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/6
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1>Login</h1><br>
<%
    if(!(request.getAttribute("message")==null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<form method="post" action="login">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp"%>

