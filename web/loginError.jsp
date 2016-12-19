<%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/12
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<html>
<head>
    <title>错误页面</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="jquery-1.8.3/jquery.js"></script>
</head>
<body>
<jsp:useBean id="tmp" class="com.fulinhua.bean.Student" scope="session">

</jsp:useBean>
您输入的id:<%=tmp.getId()%>不存在或者密码错误<br>
<a href="StudentLogin.jsp">返回</a>
</body>
</html>
