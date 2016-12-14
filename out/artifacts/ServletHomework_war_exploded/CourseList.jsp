<%@ page import="com.fulinhua.bean.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fulinhua.dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/11
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
    StudentDao dao=new StudentDao();
    ArrayList<Course> list=dao.getCourseList();
    if(session.getAttribute("username")==null){//是游客
        int pageCounter= Integer.parseInt((String) application.getAttribute("pageCounter"));
        pageCounter++;
        application.setAttribute("pageCounter", Integer.toString(pageCounter));
        int visitCounter= Integer.parseInt((String) application.getAttribute("visitCounter"));
        visitCounter++;
        application.setAttribute("visitCounter", Integer.toString(visitCounter));
    }

%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程列表</title>
</head>
<script>
    function checkLeave(){
        window.location.href="index.jsp";
    }
</script>
<body onunload="checkLeave()">
<a href="#">添加课程</a>
<a href="#">课程列表</a>
<table border="1">
    <tr>
        <th>编号</th>
        <th>名称</th>
    </tr>
    <% for(Course course:list){ %>
    <tr>
        <th><%=course.getId()%></th>
        <th><%=course.getName()%></th>
    </tr>
    <%}%>
</table>
</body>
</html>