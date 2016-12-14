package com.fulinhua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        ArrayList<String> online = (ArrayList<String>)getServletContext().getAttribute("online");
        int pageCounter=Integer.parseInt((String)getServletContext().getAttribute("pageCounter"));
        System.out.println("LoginServlet" + online);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("");
        out.println("  <title>用户列表</title>");
        out.println("  ");
       // out.println("当前用户是：" + username);
        out.print("    <hr><h3>在线用户列表</h3>");
        out.print("当前在线用户总数"+pageCounter+"<br>");
        int size = online == null ? 0 : online.size();
        for (int i = 0; i < size; i++) {
            if(i > 0){
                out.println("<br>");
            }
            out.println(i + 1 + "." + online.get(i));
        }

        //注意: 要对链接URL进行自动重写处理
        out.println("<hr/><a href=\"" + response.encodeURL("logoutListener") + "\">注销</a>");
        out.println("  ");
        out.println("");
        out.flush();
        out.close();
    }

    }
