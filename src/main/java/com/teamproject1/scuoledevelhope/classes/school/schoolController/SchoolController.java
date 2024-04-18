package com.teamproject1.scuoledevelhope.classes.school.schoolController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.schoolService.SchoolService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @GetMapping("/get-all")
    public BaseResponseList<School> findAll() {
        return schoolService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @GetMapping("/get-by-id")
    public BaseResponseElement<School> findById(@RequestParam UUID id) {
        return schoolService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<School> save(@RequestBody School school) {
        return schoolService.save(school);
    }

    @FloorLevelAuthorization(floorRole = "SUPER_ADMIN")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<School> delete(@RequestParam UUID id) {
        return schoolService.deleteById(id);
    }
}
