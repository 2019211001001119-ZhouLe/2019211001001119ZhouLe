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
<body>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h1> c:forEach loog to print 1 to 10</h1>

    <ul>
        <c:forEach var="i" begin="1" end="10">
        <li>$${i}</li>
        </c:forEach>
    </ul>
    <%-- todo 1 : run assignement1.jsp  --%>
    <%-- todo 2 : use c:forEach to print list 1,3,5,7,9   --%>
   <%-- todo 3 : use c:forEach to print 2,4,6,8,10   --%>
<ul>
        <c:forEach var="i" begin="1" end="9" step="2">
            <li>${i}</li>
        </c:forEach>
</ul>
<ul>
    <c:forEach var="i" begin="2" end="10" step="2">
        <li>${i}</li>
    </c:forEach>
</ul>
<% String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
   pageContext.setAttribute("words", words);
%>
    <%-- todo 4 : use c:forEach to print all elements of array --%>
<ul>
    <c:forEach var="i" begin="0" end="9">
        <li>${words[i]}</li>
    </c:forEach>
</ul>
    <%-- todo 5 : use c:forEach to print "one","three","five","seven","nine"  of array --%>
<ul>
    <c:forEach var="i" begin="0" end="8" step="2">
        <li>${words[i]}</li>
    </c:forEach>
</ul>
<%
List<Person> personList=new ArrayList<Person>();
personList.add(new Person("Tom",new Dog("Tommy")));
personList.add(new Person("Sam",new Dog("Sammy")));
// todo 6 : add a new person into PersonList - person name and dog name
request.setAttribute("AllPerson",personList);
%>
<%--//todo 7: use c:forEach to print person name :   and persons' dog name : --%>
<ul>
    <c:forEach items="${AllPerson}" var="i">
        <li>${i.name}:${i.dog.name}</li>
    </c:forEach>
</ul>
<%
    String str="one:two:three-four-five";
    request.setAttribute("str",str);
%>
<%--todo 8 : use c:forToken to print all words --%>
<ul>
    <c:forTokens var="i" items="${str}" delims=":" varStatus="t1">
        <c:forTokens var="j" items="${t1.current}" delims="-">
            <li>${j}</li>
        </c:forTokens>
    </c:forTokens>
</ul>
</body>
</html>
