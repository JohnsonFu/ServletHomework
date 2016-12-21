package com.fulinhua.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class UserCountListener implements ServletContextListener, ServletContextAttributeListener,HttpSessionAttributeListener {

    private ServletContext application = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化一个application对象
        application = servletContextEvent.getServletContext();
        //设置一个列表属性，用于保存在线用户名
        int pageCounter=0;
        this.application.setAttribute("pageCounter",Integer.toString(pageCounter));//保存在线人数
        this.application.setAttribute("visitCounter",Integer.toString(0));//保存在线人数
        this.application.setAttribute("online", new ArrayList<String>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {



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
        ArrayList<String> onlines = (ArrayList<String>) this.application.getAttribute("online");
        if("username".equals(httpSessionBindingEvent.getName())){
           for(int i=0;i<onlines.size();i++){
               String username=(String)httpSessionBindingEvent.getValue();
               if(onlines.get(i).equals(username)){
                   onlines.remove(i);
                   onlines.add((String)httpSessionBindingEvent.getSession().getAttribute("username"));
               }
           }
        }
        //将添加后的列表重新设置列application属性中.
        this.application.setAttribute("online", onlines);
    }

}
