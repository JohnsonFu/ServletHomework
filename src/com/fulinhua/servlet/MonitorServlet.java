package com.fulinhua.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class MonitorServlet extends HttpServlet{

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

        String username=(String)request.getSession().getAttribute("username");
        ArrayList<String> online = (ArrayList<String>)getServletContext().getAttribute("online");//在线用户列表
        int pageCounter=Integer.parseInt((String)getServletContext().getAttribute("pageCounter"));//总人数
        int visitCounter=Integer.parseInt((String)getServletContext().getAttribute("visitCounter"));//游客人数
        try {
            getServletContext().getRequestDispatcher("/Monitor.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    }
