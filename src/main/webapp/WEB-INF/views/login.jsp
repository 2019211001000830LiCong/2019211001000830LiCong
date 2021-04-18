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
<%
    Cookie[] allCookies=request.getCookies();
    String username,password,remeberMeVal;
    if(allCookies!=null)
    {
        for(Cookie c:allCookies)
        {
            if(c.getName().equals("cUsername"))
            {
                username=c.getValue();
            }
            if(c.getName().equals("cPassword"))
            {
                password=c.getValue();
            }
            if(c.getName().equals("remeberMeVal"))
            {
                remeberMeVal=c.getValue();
            }
        }
    }
%>

<form   method="post" action="login">
    Username:<input  name="username" type="text" value="<%username%>"> <br/>
    Password:<input  name="password" type="password" value="<%password%>"> <br/>
    <input type="checkbox" name="remeberMe" value="1" <%= remeberMeVal.equals("1")?"checked":""%>/> Remeber me<br/>
    <input  type="submit" value="login"/>
</form>

<%@include file="footer.jsp"%>
</body>
</html>
