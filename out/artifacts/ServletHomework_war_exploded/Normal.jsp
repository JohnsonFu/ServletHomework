<%@ page import="com.fulinhua.bean.StudentCourse" %>
<%@ page import="com.fulinhua.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: fulinhua
  Date: 2016/12/28
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>标准</title></head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-1.8.3/jquery.js"></script>
<BODY>
<jsp:useBean id="student"
             type="com.fulinhua.bean.Student"
             scope="session"></jsp:useBean>
<jsp:useBean id="courseList" type="com.fulinhua.bean.StudentCourseList" scope="session"></jsp:useBean>
<jsp:useBean id="item" class="com.fulinhua.bean.StudentCourse" scope="page"></jsp:useBean>
<div  style="width:50%;margin-left:25%;">
    <h2>标准页面</h2>
    <a href="/ServletHomework/logout.student">退出登录</a><br>
    学生ID:<jsp:getProperty name="student" property="id"></jsp:getProperty>
    学生姓名:<jsp:getProperty name="student" property="name"></jsp:getProperty><br>
    <table width="50%"  class="table table-bordered">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>状态</th>
            <th>退课</th>
        </tr>
        <%

            for (int i = 0; i < courseList.getStudentCourseList().size(); i++) {
                item=(StudentCourse)courseList.getStudentCourseList().get(i);
                pageContext.setAttribute("item",item);
        %>
        <tr>
            <th><jsp:getProperty name="item" property="courseid"></jsp:getProperty> </th>
            <th><jsp:getProperty name="item" property="name"></jsp:getProperty></th>
            <th>已测验</th>
            <form action="/ServletHomework/quitcourse" method="post">
                <th><input type="hidden" name="cid" value=<%=String.valueOf(item.getId())%>><input type="submit" value="退课"></th>
            </form>
        </tr>
        <%}%>

    </table>
</div>

</body>
</html>

