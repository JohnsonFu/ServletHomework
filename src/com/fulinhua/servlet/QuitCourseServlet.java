package com.fulinhua.servlet;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;
import com.fulinhua.bean.StudentCourseList;
import com.fulinhua.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class QuitCourseServlet extends HttpServlet {
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
        String courseid=request.getParameter("cid");
        System.out.println(courseid);
        ServiceFactory.getStudentService().QuitClass(Integer.parseInt(courseid));
        StringBuffer location=request.getRequestURL();

        HttpSession session=request.getSession();
        Student student=(Student)session.getAttribute("student");
        List<StudentCourse> list=ServiceFactory.getStudentService().getStudentCourseList(student.getId());
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

            getServletContext().getRequestDispatcher("/Warning.jsp").forward(request, response);


        }else{//所有科目测验都完成
            getServletContext().getRequestDispatcher("/Normal.jsp").forward(request, response);
        }

    }
    }
