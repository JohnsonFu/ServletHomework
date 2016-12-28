package com.fulinhua.dao.impl;

import com.fulinhua.bean.Course;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.CourseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class CourseDaoImpl extends BaseDao implements CourseDao  {


    @Override
    public ArrayList<Course> getCourseList() throws SQLException {
        ArrayList<Course> list=new ArrayList<Course>();
        PreparedStatement pstmt=null;
        String sql="select * from tb_course";
        pstmt=con.prepareStatement(sql);
        ResultSet resultSet=pstmt.executeQuery();
        int rowCount = 0;
        while(resultSet.next())
        {
            Course temp=new Course();
            temp.setId(resultSet.getInt("id"));
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
}
