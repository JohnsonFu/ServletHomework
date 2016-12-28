package com.fulinhua.dao;

import com.fulinhua.bean.Student;

import java.sql.SQLException;

/**
 * Created by fulinhua on 2016/12/28.
 */
public interface StudentDao {
    public Student isExistStudent(long id, String password) throws SQLException;
}
