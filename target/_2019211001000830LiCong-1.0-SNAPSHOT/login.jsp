<%--
  Created by IntelliJ IDEA.
  User: 85821
  Date: 2021/4/6
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Login</h1>

<%
    if(!(request.getAttribute("message")==null))
        out.println("<h3 size=\"4\" color=\"red\">"+request.getAttribute("message")+"</h3>");
%>

<form  id="login" method="post" action="/login">
    <label for="username">username</label>
    <input id="username" name="username" type="text"> <br/>

    <label for="username">password</label>
    <input id="password" name="password" type="password"> <br/>

    <input class="submit" type="submit" value="login">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
