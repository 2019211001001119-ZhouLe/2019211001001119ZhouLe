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
    Cookie [] allCookies = request.getCookies();
    for (Cookie c:allCookies) {
        out.println("<br/>"+c.getName()+" --- "+c.getValue());
    }
%>
<%
    User u=(User) session.getAttribute("user");
%>

<table>
    <tr>
        <td>username</td><td><%= u.getUsername() %></td>
    </tr><tr>
        <td>password</td><td><%= u.getPassword() %></td>
    </tr><tr>
        <td>email</td><td><%= u.getEmail() %></td>
    </tr><tr>
        <td>gender</td><td><%= u.getGender() %></td>
    </tr><tr>
        <td>birth</td><td><%= u.getBirthdate() %></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
