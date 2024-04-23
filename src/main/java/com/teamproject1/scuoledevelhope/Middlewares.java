package com.teamproject1.scuoledevelhope;

import com.teamproject1.scuoledevelhope.classes.meeting.MeetingMiddleware;
import com.teamproject1.scuoledevelhope.classes.user.UserMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Middlewares implements WebMvcConfigurer {

    @Autowired
    UserMiddleware userMiddleware;

    @Autowired
    MeetingMiddleware meetingMiddleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userMiddleware);
        registry.addInterceptor(meetingMiddleware);
    }
}
