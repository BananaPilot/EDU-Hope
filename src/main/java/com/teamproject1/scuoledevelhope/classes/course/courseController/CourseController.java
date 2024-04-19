package com.teamproject1.scuoledevelhope.classes.course.courseController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.courseService.CourseService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/get-all")
    public BaseResponseList<Course> findAll() {
        return courseService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Course> findById(@RequestParam UUID id) {
        return courseService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<Course> save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Course> delete(@RequestParam UUID id) {
        return courseService.deleteById(id);
    }
}

