package com.teamproject1.scuoledevelhope.classes.classP.classController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.classService.ClassService;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-all")
    public BaseResponseList<Classes> findAll() {
        return classService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Classes> findById(@Valid @RequestParam Long id) {
        return classService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR") //CONTROLLA FABIO
    @GetMapping("/get-tutor")
    public BaseResponseElement<Tutor> getTutorByClass(@Valid @RequestParam Long idClass) {
        return classService.getTutorByClass(idClass);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR") //CONTROLLA FABIO
    @GetMapping("/get-coordinator")
    public BaseResponseElement<Coordinator> getCoordinatorByClass(@Valid @RequestParam Long idClass) {
        return classService.getCoordinatorByClass(idClass);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR") //CONTROLLA FABIO
    @GetMapping("/get-course")
    public BaseResponseElement<Course> getCourseByClass(@Valid @RequestParam Long idClass) {
        return classService.getCourseByClass(idClass);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR") //CONTROLLA FABIO
    @GetMapping("/get-students")
    public BaseResponseList<Student> getStudentsByClass(@Valid @RequestParam Long idClass) {
        return classService.getStudentsByClass(idClass);
    }


    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<Classes> save(@Valid @RequestBody Classes classes) {
        return classService.save(classes);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Classes> delete(@Valid @RequestParam Long id) {
        return classService.deleteById(id);
    }


}
