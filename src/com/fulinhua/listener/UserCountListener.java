package com.fulinhua.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class UserCountListener implements ServletContextListener,HttpSessionAttributeListener, HttpSessionListener {

    private ServletContext application = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化一个application对象
        application = servletContextEvent.getServletContext();
        //设置一个列表属性，用于保存在线用户名
        this.application.setAttribute("online", new ArrayList<String>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        ArrayList<String> onlines = (ArrayList<String>) this.application.getAttribute("online");
        if("username".equals(httpSessionBindingEvent.getName())){
            onlines.add((String) httpSessionBindingEvent.getValue());
        }
        //将添加后的列表重新设置列application属性中.
        this.application.setAttribute("online", onlines);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
