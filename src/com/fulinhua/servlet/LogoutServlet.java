package com.fulinhua.servlet;

import com.fulinhua.bean.Student;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/14.
 */
public class LogoutServlet extends HttpServlet {
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
        Student student=(Student)session.getAttribute("student");
        session.invalidate();
        ServletContext Context= getServletContext();
        int pageCounter= Integer.parseInt((String) Context.getAttribute("pageCounter"));
        pageCounter--;
        Context.setAttribute("pageCounter", Integer.toString(pageCounter));
        ArrayList<String> online = (ArrayList<String>)getServletContext().getAttribute("online");
     String username=student.getName();
      for(int i=0;i<online.size();i++){
          if(online.get(i).equals(username)){
              online.remove(i);
              break;
          }
      }
        Context.setAttribute("online", online);
        response.sendRedirect("StudentLogin.jsp");



    }

    }
