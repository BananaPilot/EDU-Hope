package com.teamproject1.scuoledevelhope;

import com.teamproject1.scuoledevelhope.classes.register.RegisterInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class Interceptors implements WebMvcConfigurer {

    private final RegisterInterceptor registerInterceptor;

    public Interceptors(RegisterInterceptor registerInterceptor) {
        this.registerInterceptor = registerInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(registerInterceptor);
    }
}
