package com.fulinhua.servlet;

import com.fulinhua.bean.User;
import com.fulinhua.dao.UserDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class UserServlet extends HttpServlet {
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
        UserDao dao = new UserDao();
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        User user=dao.getUser(username,password);
        if(user==null){
            try {
                response.sendRedirect("/ServletHomework/loginError.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            request.getSession().setAttribute("username",username);
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>用户主页</title></head>");
                out.println(" <BODY>");
                out.println("欢迎"+user.getUsername()+"登陆");
            out.println("</BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
        }

    }
}
