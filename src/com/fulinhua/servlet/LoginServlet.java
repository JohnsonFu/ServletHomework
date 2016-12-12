package com.fulinhua.servlet;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;
import com.fulinhua.dao.StudentDao;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class LoginServlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            this.execute(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            this.execute(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
      StudentDao dao=new StudentDao();
      Long id= Long.valueOf(request.getParameter("id"));
        String password=request.getParameter("password");
        Student student=dao.isExistStudent(id,password);
        if(student==null){//登录失败，调到错误页面
            try {
                response.sendRedirect("/ServletHomework/loginError.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{//登陆成功
            HttpSession session=request.getSession(true);
           session.setAttribute("student",student);
           List<StudentCourse> list=dao.getStudentList(id);



            response.setCharacterEncoding("UTF-8");
           // request.setCharacterEncoding("UTF-8");

            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            ServletContext context=getServletConfig().getServletContext();
            String dbdriver=context.getInitParameter("myname");
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>课程列表</title></head>");
            out.println(" <BODY>");
            out.println("学生ID:"+student.getId());
            out.println("学生姓名:"+student.getName()+"<br>");
            out.println("<table border=\"1\">\n" +
                    "    <tr>\n" +
                    "        <th>编号</th>\n" +
                    "        <th>名称</th>\n" +
                    "        <th>状态</th>\n" +
                    "    </tr>");

            for(StudentCourse course:list){
                out.println("<tr>");
                out.println(" <th>"+course.getCourseid()+"</th>");
                out.println(" <th>"+course.getName()+"</th>");
                if(course.isHasExam()) {
                    out.println(" <th>" + "已测验" + "</th>");
                }else{
                    out.println(" <th style=\"color:red\">" + "未测验" + "</th>");
                }
                out.println("</tr>");
            }
            out.println("</BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();




        }




    }
}
