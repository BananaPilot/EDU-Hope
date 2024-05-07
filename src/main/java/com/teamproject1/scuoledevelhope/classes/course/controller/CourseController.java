package com.teamproject1.scuoledevelhope.classes.course.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseWithClassesDto;
import com.teamproject1.scuoledevelhope.classes.course.service.CourseService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@FloorLevelAuthorization(floorRole = "ADMIN")
    @NoAuthorization
    @GetMapping("/all")
    public BaseResponseList<CourseWithClassesDto> findAll() {
        return courseService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/{id}")
    public BaseResponseElement<CourseWithClassesDto> findById(@Valid @PathVariable Long id) {
        return courseService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<CourseDto> save (@Valid @RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @DeleteMapping("/{id}")
    public BaseResponseElement<CourseDto> delete(@Valid @PathVariable Long id) {
        return courseService.deleteById(id);
    }
}

