<%--
  Created by IntelliJ IDEA.
  User: homosapien
  Date: 2021/3/12
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        validation = function(){
            var ext = /^\S+$/;
            if(!ext.test(document.getElementsByName("name")[0].value)){
                document.getElementsByName("name")[0].style.color="red";
            }
            else {
                document.getElementsByName("name")[0].style.color="black";
            }
            var ext = /^.{8,}$/;
            if(!ext.test(document.getElementsByName("id")[0].value)){
                document.getElementsByName("id")[0].style.color="red";
            }
            else {
                document.getElementsByName("id")[0].style.color="black";
            }
            ext = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            if(!ext.test(document.getElementsByName("email")[0].value)){
                document.getElementsByName("email")[0].style.color="red";
            }
            else {
                document.getElementsByName("email")[0].style.color="black";
            }
            ext = /^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/;
            if(!ext.test(document.getElementsByName('birthdate')[0].value)){
                document.getElementsByName("birthdate")[0].style.color="red";
            }
            else {
                document.getElementsByName("birthdate")[0].style.color="black";
            }
        }
    </script>
    <title>Title</title>
</head>
<body>
<form name="myForm" method="post">
    Please use keyboard input<br/>
    Name* :<input type="text" name="name" onkeyup="validation()" autocomplete="off"><br/>
    password* :<input type="text" name="id" onkeyup="validation()" autocomplete="off"><br/>
    E-mail* :<input type="text" name="email" onkeyup="validation()" autocomplete="off"><br/>
    Birthdate* :<input type="text" name="birthdate" onkeyup="validation()" autocomplete="off"><br/>
    sex* :<input type="radio" name="sex" value="0">male<input type="radio" name="sex" value="1">female<br/>
    <input type="submit" value="Click to submit">
</form>
</body>
</html>
