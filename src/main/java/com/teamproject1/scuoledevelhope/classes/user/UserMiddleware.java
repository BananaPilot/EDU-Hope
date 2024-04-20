package com.teamproject1.scuoledevelhope.classes.user;

import com.bananapilot.samplespringauthenticationframework.types.UserDetails;
import com.bananapilot.samplespringauthenticationframework.utils.Constants;
import com.bananapilot.samplespringauthenticationframework.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class UserMiddleware implements HandlerInterceptor {

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return request.getRequestURI().contains("dashboard") && handle(request, response);
    }

    public boolean handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Jws<Claims> claimsJws = jwtUtils.validate(request.getHeader(Constants.AUTHORIZATION_HEADER));
        User user = User.UserBuilder.anUser()
                .withId(claimsJws.getBody().get("user-id", Long.class))
                .withUsername(claimsJws.getBody().get("user-username", String.class))
                .build();
        return user.getId() == Long.parseLong(request.getRequestURI().split("/")[3]);
    }
}
