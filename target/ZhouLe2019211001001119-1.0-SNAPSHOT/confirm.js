validation = function(){
    var ext = /^\S+$/;
    if(!ext.test(document.getElementsByName("name")[0].value)){
        document.getElementsByName("name")[0].style.color="red";
    }
    else {
        document.getElementsByName("name")[0].style.color="black";
    }
    var ext = /^.{8,}$/;
    if(!ext.test(document.getElementsByName("password")[0].value)){
        document.getElementsByName("password")[0].style.color="red";
    }
    else {
        document.getElementsByName("password")[0].style.color="black";
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