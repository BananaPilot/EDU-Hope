package com.teamproject1.scuoledevelhope.classes.student.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.service.StudentService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public BaseResponseList<Student> findAll() {
        return studentService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/findById")
    public BaseResponseElement<Student> findById(@RequestParam Long id) {
        return studentService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/deleteById")
    public BaseResponseElement<Student> delete(@RequestParam Long id) {

        return studentService.deleteById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Errore di validazione: " + bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        BaseResponseElement<Student> response = studentService.save(student);

        if (response.isSuccess()) {
            return ResponseEntity.ok("Studente salvato con successo");
        } else {
            return ResponseEntity.badRequest().body(response.getMessage());
        }
    }



}
