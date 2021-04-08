<%--
  Created by IntelliJ IDEA.
  User: homosapien
  Date: 2021/3/12
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<script src="confirm.js"></script>
<form name="myForm" method="post" action="${pageContext.request.contextPath}/register">
    Name* :<input type="text" name="name" onkeyup="validation()" autocomplete="off"><br/>
    password* :<input type="text" name="password" onkeyup="validation()" autocomplete="off"><br/>
    E-mail* :<input type="text" name="email" onkeyup="validation()" autocomplete="off"><br/>
    Birthdate* :<input type="text" name="birthdate" onkeyup="validation()" autocomplete="off"><br/>
    sex* :<input type="radio" name="sex" value="male">male<input type="radio" name="sex" value="female">female<br/>
    <input type="submit" value="Click to submit">
</form>
<%@include file="footer.jsp"%>