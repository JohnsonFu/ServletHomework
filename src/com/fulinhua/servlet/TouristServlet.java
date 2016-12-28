package com.fulinhua.servlet;

import com.fulinhua.bean.Course;
import com.fulinhua.bean.CourseList;
import com.fulinhua.factory.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class TouristServlet extends HttpServlet {

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
        HttpSession session=request.getSession();
        ArrayList<Course> list= ServiceFactory.getCourseService().getAllCourse();
        CourseList clist=new CourseList();
        clist.setCourseList(list);
        session.setAttribute("clist",clist);
        ServletContext application=this.getServletContext();
        if(session.getAttribute("username")==null){//是游客
            int pageCounter= Integer.parseInt((String) application.getAttribute("pageCounter"));
            pageCounter++;
            application.setAttribute("pageCounter", Integer.toString(pageCounter));
            int visitCounter= Integer.parseInt((String) application.getAttribute("visitCounter"));
            visitCounter++;
            application.setAttribute("visitCounter", Integer.toString(visitCounter));
        }
        try {
            application.getRequestDispatcher("/Tourist.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
    }
