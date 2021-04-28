<%--
  Created by IntelliJ IDEA.
  User: homosapien
  Date: 2021/4/28
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update </h1>
<%
  User u =(User) session.getAttribute("user");
%>
<form name="myForm" method="post" action="${pageContext.request.contextPath}/UpdateUser">
  <input type="hidden" name="id" value="<%=u.getId()%>">
  Name :<input type="text" name="name" value="<%=u.getUsername()%>"><br/>
  password :<input type="text" name="password" value="<%=u.getPassword()%>"><br/>
  E-mail :<input type="text" name="email" value="<%=u.getEmail()%>"><br/>
  Birthdate :<input type="text" name="birthdate" value="<%=u.getBirthdate()%>"><br/>
  sex :<input type="radio" name="sex" value="male" <%="male".equals(u.getGender())?"checked":""%>>male
  <input type="radio" name="sex" value="female" <%="female".equals(u.getGender())?"checked":""%>>female<br/>
  <input type="submit" value="Save changes">
</form>
<%@include file="footer.jsp"%>
