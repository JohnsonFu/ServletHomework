package com.fulinhua.factory;

import com.fulinhua.service.CourseService;
import com.fulinhua.service.StudentService;
import com.fulinhua.service.impl.CourseServiceImpl;
import com.fulinhua.service.impl.StudentServiceImpl;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class ServiceFactory {
    public static StudentService getStudentService(){
        return new StudentServiceImpl();
    }
    public static CourseService getCourseService(){
        return new CourseServiceImpl();
    }
}
