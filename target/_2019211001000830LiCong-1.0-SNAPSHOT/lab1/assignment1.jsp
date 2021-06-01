<%@ page import="com.lab1.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab1.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignemnt1</title>
</head>
<br>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h1> c:forEach loog to print 1 to 10</h1>

    <ul>
        <c:forEach var="i" begin="1" end="10">
        <li>${i}</li>
        </c:forEach>
    </ul>
<h1> c:forEach loog to print list 1,3,5,7,9</h1>
<ul>
    <c:forEach var="i" begin="1" end="10" step ="2">
        <li>${i}</li>
    </c:forEach>

</ul>
<h1> c:forEach loog to print 2,4,6,8,10</h1>
<ul>
    <c:forEach var="i" begin="2" end="10" step ="2">
        <li>${i}</li>
    </c:forEach>

</ul>
    <%-- todo 1 : run assignement1.jsp  --%>
    <%-- todo 2 : use c:forEach to print list 1,3,5,7,9   --%>
   <%-- todo 3 : use c:forEach to print 2,4,6,8,10   --%>


<% String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
   pageContext.setAttribute("words", words);
%>
<h1> c:forEach to print all elements of array</h1>
<c:forEach var="item" items="${words }" >
    <li>${item}</li>
</c:forEach>
<h1> c:forEach to print "one","three","five","seven","nine"  of array</h1>
<c:forEach var="item" items="${words }" step="2">
    <li>${item }</li>
</c:forEach>
    <%-- todo 4 : use c:forEach to print all elements of array --%>
    <%-- todo 5 : use c:forEach to print "one","three","five","seven","nine"  of array --%>
<%
List<Person> personList=new ArrayList<Person>();
personList.add(new Person("Tom",new Dog("Tommy")));
personList.add(new Person("Sam",new Dog("Sammy")));
personList.add(new Person("Mike",new Dog("kitty")));
// todo 6 : add a new person into PersonList - person name and dog name
request.setAttribute("AllPerson",personList);
%>
<c:forEach var="item" items="${AllPerson }">
    <c:out value="${item }"/><br/>
</c:forEach>
<%--//todo 7: use c:forEach to print person name :   and persons' dog name : --%>
<%
    String str="one:two:three-four-five";
%>
<%--todo 8 : use c:forToken to print all words --%>
</body>
</html>
