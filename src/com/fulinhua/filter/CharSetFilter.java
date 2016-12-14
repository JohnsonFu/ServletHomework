package com.fulinhua.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by fulinhua on 2016/12/12.
 */
public class CharSetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      System.out.println("字符串filter初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         servletRequest.setCharacterEncoding("UTF-8");
         servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
