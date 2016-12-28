package com.fulinhua.servlet;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;
import com.fulinhua.bean.StudentCourseList;
import com.fulinhua.factory.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class LoginServlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.execute(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.execute(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
      Long id= Long.valueOf(request.getParameter("id"));
        String password=request.getParameter("password");
        ServletContext context = getServletContext();
        Student student= ServiceFactory.getStudentService().Login(id,password);
        if(student==null){//登录失败，调到错误页面
            try {
                Student tmp=new Student();
                tmp.setId(id);
                request.getSession().setAttribute("tmp",tmp);
                response.sendRedirect("/ServletHomework/loginError.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{//登陆成功
            HttpSession session=request.getSession(true);
            String username= (String) session.getAttribute("username");
            if(username==null) {
                ServletContext Context = getServletContext();
                int pageCounter = Integer.parseInt((String) Context.getAttribute("pageCounter"));
                pageCounter++;
                Context.setAttribute("pageCounter", Integer.toString(pageCounter));
            }
           session.setAttribute("student",student);
            request.getSession().setAttribute("username",student.getName());
           List<StudentCourse> list=ServiceFactory.getStudentService().getStudentCourseList(id);
            StudentCourseList courseList=new StudentCourseList();
            courseList.setStudentCourseList(list);
            session.setAttribute("courseList",courseList);
            boolean isnormal=true;//是正常页面
            for(StudentCourse test:list){
                if(test.isHasExam()==false){
                    isnormal=false;
                }
            }
            if(isnormal==false) {//存在未测验的项目

                context.getRequestDispatcher("/Warning.jsp").forward(request, response);


            }else{//所有科目测验都完成
                context.getRequestDispatcher("/Normal.jsp").forward(request, response);
            }


        }




    }
}
