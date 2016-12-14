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
<form action="/ServletHomework/login.student" method="post">
   学号<input type="text" name="id"/><br>
   密码<input type="password" name="password"/><br>
    <input type="submit" value="登录"></inputsubmit>
</form>
    </div>
</body>
</html>