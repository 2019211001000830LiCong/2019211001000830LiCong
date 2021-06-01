<%@ page import="com.mysql.cj.protocol.Resultset" %><%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/11
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border=1>
    <tr><td>Id</td>
    <td>Username</td>
    <td>Password</td>
    <td>Email</td><td>Gender</td>
        <td>Birthday</td>
    </tr>
    <%
        Resultset rs=(Resultset) request.getAttribute("rsname");
        if(rs==null){
            %>
    <tr><td>No data!!!</td></tr>
    <%}else {
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt("id")+"</td>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
    }%>
</table>
<%@include file="footer.jsp"%>