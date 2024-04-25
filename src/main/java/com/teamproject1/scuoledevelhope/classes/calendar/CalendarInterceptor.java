package com.teamproject1.scuoledevelhope.classes.calendar;

import com.bananapilot.samplespringauthenticationframework.utils.Constants;
import com.bananapilot.samplespringauthenticationframework.utils.JWTUtils;
import com.teamproject1.scuoledevelhope.classes.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
@Configuration
public class CalendarInterceptor implements HandlerInterceptor {
    @Autowired
    JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().contains("/calendar")) {
            return true;
        }
        if (request.getRequestURI().contains("/calendar/meeting") || request.getRequestURI().contains("/meeting/all") && handle(request)) {
            return true;
        }
        response.sendError(HttpStatus.FORBIDDEN.value());
        return false;
    }

    public boolean handle(HttpServletRequest request) {
        Jws<Claims> claimsJws = jwtUtils.validate(request.getHeader(Constants.AUTHORIZATION_HEADER).split(" ")[1]);
        User user = User.UserBuilder.anUser()
                .withId(claimsJws.getBody().get("user-id", Long.class))
                .withUsername(claimsJws.getBody().get("user-username", String.class))
                .build();
        return user.getId() == Long.parseLong(request.getRequestURI().split("/")[3]);
    }
}
