package com.pengkey.config;

import com.pengkey.filter.FieldFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        RemoteIpFilter remoteIpFilter=new RemoteIpFilter();
        return remoteIpFilter;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FieldFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("fieldFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }



}
