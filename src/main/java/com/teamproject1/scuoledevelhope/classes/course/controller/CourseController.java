package com.teamproject1.scuoledevelhope.classes.course.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseWithClassesDto;
import com.teamproject1.scuoledevelhope.classes.course.service.CourseService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all-class/{id}")
    public CourseWithClassesDto findAll(@PathVariable Long id, @RequestParam int limit, int page) {
        return courseService.findAllClass(id, limit, page);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<CourseDto> save(@Valid @RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @DeleteMapping("/{id}")
    public BaseResponseElement<CourseDto> delete(@Valid @PathVariable Long id) {
        return courseService.deleteById(id);
    }
}

