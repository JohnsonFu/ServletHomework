package com.fulinhua.dao;

import com.fulinhua.bean.User;

import java.sql.*;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class UserDao {
    Connection con;
    public UserDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序
            //Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Success loading Mysql Driver!");
        } catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/newtable", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

        System.out.println("Success connect Mysql server!");
    }

    public User getUser(String username, String password) throws SQLException {
        PreparedStatement pstmt=null;
        String sql="select * from tb_user where username=? and password=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        ResultSet resultSet=pstmt.executeQuery();
        int rowCount = 0;
        if(resultSet.next())
        {
            rowCount++;
        }
        if(rowCount==0){
            return null;
        }else{
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }


    }

}
