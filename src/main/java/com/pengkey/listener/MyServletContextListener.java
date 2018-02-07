package com.pengkey.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{
    private static Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("MyServletContextListener has contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("MyServletContextListener has contextDestroyed");
    }
}
