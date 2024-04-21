package com.teamproject1.scuoledevelhope.classes.student.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.service.StudentService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
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

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/findById")
    public BaseResponseElement<Student> findById(@Valid @RequestParam Long id) {
        return studentService.findById(id);
    }
    @NoAuthorization
 //@FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/deleteById")
    public BaseResponseElement<Student> delete(@Valid @RequestParam Long id) {

        return studentService.deleteById(id);
    }

    public void pullinaPerFabietto(){
        System.out.println("ULLINA AL VOLO PER FABIETTO");
    }
}
