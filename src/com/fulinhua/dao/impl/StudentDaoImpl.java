package com.fulinhua.dao.impl;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.StudentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {


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
