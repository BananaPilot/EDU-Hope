package com.teamproject1.scuoledevelhope.classes.user.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.DashboardDto;
import com.teamproject1.scuoledevelhope.classes.user.service.UserService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

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
    public BaseResponseElement<User> addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/{username}")
    public BaseResponseElement<User> getByUsername(@Valid @PathVariable("username") String username) {
        return userService.getByUsername(username);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all")
    public BaseResponseList<User> getAll() {
        return userService.getAll();
    }

    @NoAuthorization
    @GetMapping("/dashboard")
    public BaseResponseElement<DashboardDto> dashboard(@RequestHeader("Authorization") String jwt) {
        return userService.getDashboard(jwt);
    }
}
