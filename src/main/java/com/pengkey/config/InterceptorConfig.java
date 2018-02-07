package com.pengkey.config;

import com.pengkey.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("----------------------------add interceptor---------------------");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*").excludePathPatterns("/login");
    }
}
