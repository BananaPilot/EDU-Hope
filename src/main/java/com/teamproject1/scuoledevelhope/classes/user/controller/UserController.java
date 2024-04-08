package com.teamproject1.scuoledevelhope.classes.user.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.BasicAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.service.UserService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @NoAuthorization()
    @PostMapping("/login")
    public String login() {
        return "JWT is in the headers";
    }

    @NoAuthorization
    @PostMapping("/user/signin")
    public BaseResponseElement<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @BasicAuthorization(roles = {"ADMIN"})
    @GetMapping("user/{username}")
    public BaseResponseElement<User> getByUsername(@PathVariable("username") String username) {
        return userService.getByUsername(username);
    }
}
