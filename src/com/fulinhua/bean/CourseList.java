package com.fulinhua.bean;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class CourseList {
    public List<Course> getCourseList() {
        return CourseList;
    }

    public void setCourseList(List<Course> courseList) {
        CourseList = courseList;
    }

    private List<Course> CourseList;
}
