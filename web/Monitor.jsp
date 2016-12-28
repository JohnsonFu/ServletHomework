<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/28
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>在线用户监控</title>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<body>
<div align="center">
    <hr><h3>在线用户列表</h3>
    当前在线用户总数:<%=application.getAttribute("pageCounter")%><br>
    当前在线游客数:<%=application.getAttribute("visitCounter")%><br>
    在线注册用户列表:<br>
    <%
        ArrayList<String> online = (ArrayList<String>)application.getAttribute("online");
        int size = online == null ? 0 : online.size();
        for (int i = 0; i < size; i++) {
            if(i > 0){
                %>
             <br>
    <%
            }%>

         <%=(i+1)%>.<%=online.get(i)%>
    <%
        }

    %>
    </div>
</body>
</html>
