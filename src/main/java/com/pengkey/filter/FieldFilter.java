package com.pengkey.filter;

import com.pengkey.compent.MyAccessDeniedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class FieldFilter implements Filter{
    private static Logger logger = LoggerFactory.getLogger(FieldFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("---------------------------FieldFilter is starting------------------------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        logger.info("request ip："+request.getRemoteAddr());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("---------------------------FieldFilter has findshed------------------------------");
    }
}
