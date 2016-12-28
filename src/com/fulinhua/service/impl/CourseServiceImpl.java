package com.fulinhua.service.impl;

import com.fulinhua.bean.Course;
import com.fulinhua.factory.DaoFactory;
import com.fulinhua.service.CourseService;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class CourseServiceImpl implements CourseService {
    @Override
    public ArrayList<Course> getAllCourse() throws SQLException {
        return DaoFactory.getCourseDao().getCourseList();
    }
}
