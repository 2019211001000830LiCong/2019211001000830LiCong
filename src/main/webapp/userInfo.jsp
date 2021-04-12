<%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/11
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
    <h1>User Info</h1>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email")%></tr>
    <tr><td>gender:</td><td><%=request.getAttribute("gender")%></tr>
    <tr><td>Birth Date:</td><td><%=request.getAttribute("BirthDate")%></tr>
</table>
<%@include file="footer.jsp"%>
