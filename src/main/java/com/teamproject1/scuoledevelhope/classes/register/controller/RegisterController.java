package com.teamproject1.scuoledevelhope.classes.register.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoListWithVote;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoWithVote;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoListWithStudent;
import com.teamproject1.scuoledevelhope.classes.register.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/{id}")
    public RegisterDtoWithVote findById(@PathVariable Long id) {
        return registerService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all-vote")
    public RegisterDtoListWithVote findAllVote() {
        return registerService.findAllVote();
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all-student")
    public RegisterDtoListWithStudent findAllStudent() {
        return registerService.findAllStudent();
    }
}
