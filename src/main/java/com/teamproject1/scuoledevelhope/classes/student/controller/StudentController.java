package com.teamproject1.scuoledevelhope.classes.student.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDtoList;
import com.teamproject1.scuoledevelhope.classes.student.service.StudentService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/findAll")
    public StudentDtoList findAll(@RequestParam int limit, int page) {
        return studentService.findAll(limit, page);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/{id}")
    public BaseResponseElement<StudentDto> findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/{id}")
    public BaseResponseElement<StudentDto> delete(@PathVariable("id") Long id) {

        return studentService.deleteById(id);
    }
    @NoAuthorization
    @PutMapping("/class")
    public BaseResponseElement<StudentDto> updateStudentClass(@RequestParam Long idStudent, Long idClass){
        return studentService.updateStudentClass(idClass, idStudent);
    }

}

