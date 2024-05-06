package com.teamproject1.scuoledevelhope.classes.register.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDTO;
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

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping
    public RegisterDTO findById(@RequestParam Long id) {
        return registerService.findById(id);
    }

}
