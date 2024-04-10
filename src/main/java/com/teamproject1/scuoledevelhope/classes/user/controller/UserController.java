package com.teamproject1.scuoledevelhope.classes.user.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.BasicAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.service.UserService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @NoAuthorization()
    @PostMapping("/login")
    public String login() {
        return "JWT is in Authorization header";
    }

    @NoAuthorization
    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseElement<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @BasicAuthorization(roles = {"ADMIN"})
    @GetMapping("/{username}")
    public BaseResponseElement<User> getByUsername(@PathVariable("username") String username) {
        return userService.getByUsername(username);
    }

    @BasicAuthorization(roles = {"ADMIN"})
    @GetMapping("/all")
    public BaseResponseList<User> getAll() {
        return userService.getAll();
    }
}
