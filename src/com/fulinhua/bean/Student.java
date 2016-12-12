package com.fulinhua.bean;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class Student {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private long id;
    private String name;
    private String password;
}
