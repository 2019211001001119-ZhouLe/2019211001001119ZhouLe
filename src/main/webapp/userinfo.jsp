<%--
  Created by IntelliJ IDEA.
  User: homosapien
  Date: 2021/4/16
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<table>
    <tr>
        <td>username</td><td><%= request.getAttribute("username") %></td>
        <td>password</td><td><%= request.getAttribute("password") %></td>
        <td>email</td><td><%= request.getAttribute("email") %></td>
        <td>gender</td><td><%= request.getAttribute("gender") %></td>
        <td>birth</td><td><%= request.getAttribute("birthdate") %></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
