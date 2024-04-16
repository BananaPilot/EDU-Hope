package com.teamproject1.scuoledevelhope.classes.student.controller;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.service.StudentService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/findAll")
    public BaseResponseList<Student>findAll(){
        return studentService.findAll();
    }
    @GetMapping("/findById")
    public BaseResponseElement<Student> findById(@RequestParam String id){
        return studentService.findById(id);
    }
    @DeleteMapping("/deleteById")
    public BaseResponseElement<Student> delete(@RequestParam String id){

        return studentService.deleteById(UUID.fromString(id));
    }
}
