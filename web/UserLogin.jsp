<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/12
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="/ServletHomework/login.user"  method="post">
    <label>账号</label><input type="text" name="username"/><br>
    <label>密码</label><input type="password" name="password"/>
    <input type="submit"  value="登录"></inputsubmit>
</form>
</body>
</html>