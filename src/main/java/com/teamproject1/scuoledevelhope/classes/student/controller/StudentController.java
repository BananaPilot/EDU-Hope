package com.teamproject1.scuoledevelhope.classes.student.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.service.StudentService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @NoAuthorization
  //@FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/findAll")
    public BaseResponseList<Student> findAll() {
        return studentService.findAll();
    }
    @NoAuthorization
   //@FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/findById/{id}")
    public BaseResponseElement<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }
    @NoAuthorization
 //@FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/deleteById")
    public BaseResponseElement<Student> delete(@RequestParam Long id) {

        return studentService.deleteById(id);
    }
}
