package com.teamproject1.scuoledevelhope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Middlewares implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {;
    }
}
