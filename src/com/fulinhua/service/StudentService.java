package com.fulinhua.service;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/28.
 */
public interface StudentService {
    public Student Login(long id, String password);
    public List<StudentCourse> getStudentCourseList(long sid);
    public boolean QuitClass(int courseid);
}
