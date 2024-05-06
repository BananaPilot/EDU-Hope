package com.teamproject1.scuoledevelhope.classes.tutor.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.tutor.dto.TutorDto;
import com.teamproject1.scuoledevelhope.classes.tutor.dto.TutorDtoList;
import com.teamproject1.scuoledevelhope.classes.tutor.service.TutorService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-all")
    public TutorDtoList findAll(@RequestParam int limit, int page) {
        return tutorService.findAll(limit, page);
    }

    @NoAuthorization
    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/{id}")
    public BaseResponseElement<TutorDto> findById(@Valid @PathVariable Long id) {
        return tutorService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save/{username}")
    public BaseResponseElement<TutorDto> save(@Valid @PathVariable String username) {
        return tutorService.save(username);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/{id}")
    public BaseResponseElement<TutorDto> delete(@Valid @PathVariable Long id) {
        return tutorService.deleteById(id);
    }


}


