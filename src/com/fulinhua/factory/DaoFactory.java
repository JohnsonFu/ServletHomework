package com.fulinhua.factory;

import com.fulinhua.dao.StudentDaoImpl;

/**
 * Created by fulinhua on 2016/12/28.
 */
public class DaoFactory {
    public static StudentDaoImpl getStudentDao(){
        return new StudentDaoImpl();
    }


}
