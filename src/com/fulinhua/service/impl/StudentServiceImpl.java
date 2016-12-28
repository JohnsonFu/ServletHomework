package com.fulinhua.service.impl;

import com.fulinhua.bean.Student;
import com.fulinhua.factory.DaoFactory;
import com.fulinhua.service.StudentService;

import java.sql.SQLException;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public Student Login(long id, String password) {
        try {
            return DaoFactory.getStudentDao().isExistStudent(id,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
