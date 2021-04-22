<%@ page import="com.ZhouLe.model.User" %><%--
  Created by IntelliJ IDEA.
  User: homosapien
  Date: 2021/4/16
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User user =(User) request.getAttribute("user");
%>

<table>
    <tr>
        <td>username</td><td><%= user.getUsername() %></td>
    </tr><tr>
        <td>password</td><td><%= user.getPassword() %></td>
    </tr><tr>
        <td>email</td><td><%= user.getEmail() %></td>
    </tr><tr>
        <td>gender</td><td><%= user.getGender() %></td>
    </tr><tr>
        <td>birth</td><td><%= user.getBirthdate() %></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
