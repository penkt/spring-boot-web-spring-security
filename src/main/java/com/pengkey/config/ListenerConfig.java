package com.pengkey.config;

import com.pengkey.listener.MyServletContextListener;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean myServletContextListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyServletContextListener());
        servletListenerRegistrationBean.setEnabled(true);
        servletListenerRegistrationBean.setOrder(1);
        return  servletListenerRegistrationBean;
    }
    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }


}
