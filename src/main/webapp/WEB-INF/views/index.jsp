<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="hello">student info week2</a>
<br/>
<a href="config">config week4</a>
<br/>
<form method="get" target="_blank" action="${pageContext.request.contextPath}/SearchServlet">
    <input type="text" name="txt" size="30">
    <select name="search">
    <option value="baidu">baidu</option>
    <option value="bing">bing</option>
    <option value="google">google</option>
    </select>
    <input type="submit" value="Search">
</form>
<%@include file="footer.jsp"%>