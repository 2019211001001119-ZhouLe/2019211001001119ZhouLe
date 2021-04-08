<%--
  Created by IntelliJ IDEA.
  User: homosapien
  Date: 2021/4/8
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>login</h1>
<form name="myForm" method="post" action="${pageContext.request.contextPath}/login">
Name :<input type="text" name="name" onkeyup="validation()" autocomplete="off"><br/>
password :<input type="text" name="password" onkeyup="validation()" autocomplete="off"><br/>
<input type="submit" value="Click to submit">
</form>
<%@include file="footer.jsp"%>
