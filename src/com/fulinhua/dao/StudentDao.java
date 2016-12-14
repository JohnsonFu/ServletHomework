package com.fulinhua.dao;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class StudentDao {
    Connection con;
    public StudentDao() {
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

        public List<StudentCourse> getStudentList(long sid) throws SQLException {//获得学生选择的课
            List<StudentCourse> list=new ArrayList<StudentCourse>();
            PreparedStatement pstmt=null;
            String sql="select * from tb_studentcourse where student_id=? ";
            pstmt=con.prepareStatement(sql);
            pstmt.setLong(1,sid);
            ResultSet resultSet=pstmt.executeQuery();
            int rowCount = 0;
            while(resultSet.next())
            {
                StudentCourse temp=new StudentCourse();
                temp.setCourseid(resultSet.getInt("courseid"));
                temp.setHasExam(resultSet.getBoolean("hasExam"));
                temp.setName(resultSet.getString("name"));
                list.add(temp);
                rowCount++;
            }
            if(rowCount==0){
                return null;
            }else{

                return list;
            }
        }

        public Student isExistStudent(long id, String password) throws SQLException {
            PreparedStatement pstmt=null;
            String sql="select * from tb_student where id=? and password=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setLong(1,id);
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
                Student student=new Student();
                student.setId(id);
                student.setPassword(password);
                student.setName(resultSet.getString("name"));
                return student;
            }


        }



}
