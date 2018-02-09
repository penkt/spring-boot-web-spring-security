package com.pengkey.config;

import com.pengkey.compent.LoginSuccessHandler;
import com.pengkey.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是”/login”
                .loginPage("/login")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .successHandler(loginSuccessHandler())
                .and()
                .logout()
                //指定登录页是”/home”
                .logoutUrl("/home")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录
                //数据库中必须存在名为persistent_logins的表
                .rememberMe()
                .tokenValiditySeconds(1209600)
                .tokenRepository(tokenRepository())
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean

    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl j=new JdbcTokenRepositoryImpl();
        j.setDataSource(dataSource);
        return j;
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }




}
