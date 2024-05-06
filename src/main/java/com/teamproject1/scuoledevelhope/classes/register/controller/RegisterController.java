package com.teamproject1.scuoledevelhope.classes.register.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.service.RegisterService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //READ
    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/all")
    public BaseResponseList<Register> findAll() {
        return registerService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping
    public BaseResponseElement<Register> findById(@Valid @RequestParam Long id) {
        return registerService.findById(id);
    }

}
