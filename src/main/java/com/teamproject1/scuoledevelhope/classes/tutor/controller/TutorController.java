package com.teamproject1.scuoledevelhope.classes.tutor.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.service.TutorService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }


    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-all")
    public BaseResponseList<Tutor> findAll() {
        return tutorService.findAll();
    }

    @NoAuthorization
    // @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Tutor> findById(@Valid @RequestParam Long id) {
        return tutorService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<Tutor> save(@Valid @RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Tutor> delete(@Valid @RequestParam Long id) {
        return tutorService.deleteById(id);
    }


}


