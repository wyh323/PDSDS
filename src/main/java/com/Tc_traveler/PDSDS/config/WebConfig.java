package com.Tc_traveler.PDSDS.config;

import com.Tc_traveler.PDSDS.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/administrator/login","/patient/register","/patient/login","/doctor/register","/doctor/login","/mail/getCode","/doctor/resetPwd","/PDSDS/sendMessage","/PDSDS/addUser","/chat/public","/ws/**");
    }
}
