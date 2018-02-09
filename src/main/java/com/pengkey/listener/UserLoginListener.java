package com.pengkey.listener;

import com.google.common.collect.Maps;
import com.pengkey.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

public class UserLoginListener implements HttpSessionListener{
    private static Logger logger = LoggerFactory.getLogger(UserLoginListener.class);

    private Map<String,Object>userSessionMap= Maps.newConcurrentMap();

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session=httpSessionEvent.getSession();

        userSessionMap.put(session.getId(),session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
