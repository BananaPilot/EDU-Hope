package com.teamproject1.scuoledevelhope.classes.user.controller;

import com.bananapilot.samplespringauthenticationframework.types.User;
import com.teamproject1.scuoledevelhope.classes.user.service.UserServiceImpl;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
//    @BasicAuthorization(roles = {"ADMIN", "SUPER-ADMIN"})
    @GetMapping
    public BaseResponseList<User> getAll() {
        return userService.getAll();
    }

}
