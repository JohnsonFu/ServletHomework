<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/12
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>学生登录</title>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<body>
<div align="center">
<h1>学生登录</h1>
<form action="/ServletHomework/login.student" method="post" onsubmit="return check()">
   学号<input type="text" name="id" /><br>
   密码<input type="password" name="password"/><br>
    <button  type="submit"  type="button" class="btn btn-small" >登录</button>
</form>
    </div>
<script type="text/javascript">
    function check() {
        var name = document.getElementsByName("id")[0].value;
        var reg1 = /^[0-9]*$/;
        if (!reg1.test(name)) {
            alert("学号必须为数字!");
            return false;
        }else {
            return true;
        }
    }
</script>
</body>
</html>