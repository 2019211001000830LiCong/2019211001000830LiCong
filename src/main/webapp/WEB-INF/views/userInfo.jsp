<%@ page import="com.LiCong.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/11
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User user = (User)request.getAttribute("user");
%>
    <h1>User Info</h1>
<table  border="1">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthday</th>
    </tr>
    <tr>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getGender()%></td>
        <td><%=user.getBirthday()%></td>
    </tr>
    <tr>
        <a href="updateUser"> Update User</a>
    </tr>
</table>
<%@include file="footer.jsp"%>
