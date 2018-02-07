package com.pengkey.config;

import com.pengkey.servlet.Myservlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new Myservlet());
        servletRegistrationBean.addUrlMappings("/myServlet");
        servletRegistrationBean.setName("myServlet");
        servletRegistrationBean.setOrder(1);
        return  servletRegistrationBean;
    }

}
