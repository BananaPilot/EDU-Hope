package com.teamproject1.scuoledevelhope.utils;

import com.bananapilot.samplespringauthenticationframework.utils.JWTUtils;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Utils {

    private final JWTUtils jwtUtils;

    public Utils(JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public User getUserFromJwt(String jwt) {
        Jws<Claims> claimsJws = jwtUtils.validate(jwt.split(" ")[1]);
        return User.UserBuilder.anUser()
                .withId(claimsJws.getBody().get("user-id", Long.class))
                .withUsername(claimsJws.getBody().get("user-username", String.class))
                .withRoles(claimsJws.getBody().get("user-roles", List.class))
                .build();
    }

    public <T> T isPresent(Optional<T> optional) {
        return optional.orElse(optional.orElseThrow(() -> new NotFoundException("Optional not found")));
    }
}
