package com.pengkey.interceptor;

import com.pengkey.filter.FieldFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("-------------LoginInterceptor is start------------------");
        logger.info("----------------preHandler--------------------");
        HttpSession session=httpServletRequest.getSession();
        if(session.getAttribute("SPRING_SECURITY_CONTEXT")==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
            return false;
        }else{
            session.setAttribute("userId", session.getAttribute("userId"));
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("----------------postHandle--------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("----------------afterCompletion--------------------");
    }
}
