package com.fulinhua.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class BaseDao {
    public Connection con;
    public BaseDao() {
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


}
