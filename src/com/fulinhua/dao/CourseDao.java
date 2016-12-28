package com.fulinhua.dao;

import com.fulinhua.bean.Course;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/28.
 */
public interface CourseDao   {
    public ArrayList<Course> getCourseList() throws SQLException;
}
