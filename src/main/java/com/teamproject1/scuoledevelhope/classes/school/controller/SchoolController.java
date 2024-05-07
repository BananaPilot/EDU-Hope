package com.teamproject1.scuoledevelhope.classes.school.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.dto.SchoolDto;
import com.teamproject1.scuoledevelhope.classes.school.service.SchoolService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @GetMapping("/all")
    public BaseResponseList<School> findAll() {
        return schoolService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @GetMapping("/{id}")
    public BaseResponseElement<School> findById(@Valid @PathVariable Long id) {
        return schoolService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<SchoolDto> save(@Valid @RequestBody SchoolDto schoolDto) {
        return schoolService.save(schoolDto);
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @DeleteMapping("/{id}")
    public BaseResponseElement<School> delete(@Valid @PathVariable Long id) {
        return schoolService.deleteById(id);
    }
}
