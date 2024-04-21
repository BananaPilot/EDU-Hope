package com.teamproject1.scuoledevelhope.classes.course.courseController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.courseService.CourseService;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
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

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/get-all")
    public BaseResponseList<Course> findAll() {
        return courseService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Course> findById(@Valid @RequestParam Long id) {
        return courseService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-classes")
    public BaseResponseList<Classes> getClassesByCourse(@Valid @RequestParam Long id) {
        return courseService.getClassesByCourse(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-tutors")
    public BaseResponseList<Tutor> getTutorsByCourse(@Valid @RequestParam Long id) {
        return courseService.getTutorsByCourse(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-tutors")
    public BaseResponseList<Student> getStudentsByCourse(@Valid @RequestParam Long id) {
        return courseService.getStudentsByCourse(id);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<Course> save(@Valid @RequestBody Course course) {
        return courseService.save(course);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Course> delete(@Valid @RequestParam Long id) {
        return courseService.deleteById(id);
    }
}

