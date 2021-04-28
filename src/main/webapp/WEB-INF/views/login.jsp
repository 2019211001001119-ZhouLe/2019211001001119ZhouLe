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
<%
    if(!(request.getAttribute("message")==null))
        out.println(request.getAttribute("message"));
%>
<%
    Cookie [] allCookies = request.getCookies();
    String username="", password="", rememberMeVale="";
    for (Cookie c:allCookies) {
        if(c.getName().equals("cUsername"))
            username=c.getValue();
        if(c.getName().equals("cPassword"))
            password=c.getValue();
        if(c.getName().equals("cRememberMe"))
            rememberMeVale=c.getValue();
    }
%>

<form name="myForm" method="post" action="${pageContext.request.contextPath}/login">
userName :<input type="text" name="name" value="<%=username%>" onkeyup="validation()" autocomplete="off"><br/>
password :<input type="text" name="password" value="<%=password%>" onkeyup="validation()" autocomplete="off"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1") ?"checked":""%>checked>RememberMe<br/>
<input type="submit" value="Click to submit">
</form>
<%@include file="footer.jsp"%>
