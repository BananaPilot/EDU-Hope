package com.teamproject1.scuoledevelhope.classes.register.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.BasicAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoListWithVote;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoWithVote;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoListWithStudent;
import com.teamproject1.scuoledevelhope.classes.register.service.RegisterService;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDtoList;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDtoList;
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
    @GetMapping("/all-vote/{registerId}")
    public VoteDtoList findAllVote(@PathVariable Long registerId, @RequestParam int limit, int page) {
        return registerService.findAllVote(registerId, limit, page);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all-student/{registerId}")
    public StudentDtoList findAllStudent(@PathVariable Long registerId, @RequestParam int limit, int page) {
        return registerService.findAllStudent(registerId, limit, page);
    }

    @BasicAuthorization(roles = {"TUTOR"})
    @GetMapping("/all")
    public RegisterDtoList findAll(@RequestHeader("Authorization") String jwt, @RequestParam int limit, int page){
        return registerService.findAllByTutor(jwt, limit, page);
    }
}
