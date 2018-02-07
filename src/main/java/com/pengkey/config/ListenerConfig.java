package com.pengkey.config;

import com.pengkey.listener.MyServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
