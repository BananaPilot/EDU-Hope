package com.teamproject1.scuoledevelhope.classes.student.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.service.StudenService;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    StudenService studentService;

    public StudentController(StudenService studentService) {
        this.studentService = studentService;
    }
                                         //  ------- FIND ALL  ------- //
    @NoAuthorization
    @GetMapping("/all")
    public BaseResponseList<Student> findAll(){
        return studentService.findAll();
    }
                                        //  ------- FIND BY ID ------- //
    public Student getStudent(@PathVariable int studentId){

        Student theStudent = studentService.findById(studentId);
        //TODO RuntimeException
        return theStudent;
    }
                                        //  -------   SAVE   ------- //
    @NoAuthorization
    @PostMapping("/save")
    public Student save(@RequestBody Student theStudent){
        //Anche nel caso in cui passiamo un ID in JSON... Imposta id su 0
        //questo serve per forzare il salvataggio del nuovo elemento... Invece dell'aggiornamento
        theStudent.setId(0);
        return studentService.save(theStudent);
    }
                                        //  -------   UPDATE  ------- //
    @NoAuthorization
    @PutMapping("/save")
    public Student update(@RequestBody Student theStudent){

        return studentService.save(theStudent);
    }
                                        // ---- DELETE BY ID -------  //
    @DeleteMapping("/delete")
    public String deleteStudent(@PathVariable int studentId){

        Student tempStudent = studentService.findById(studentId);

        if (tempStudent == null){
            //TODO EXCEPTION
            //aggiungi eccezioni fabio
        }

        studentService.deleteById(studentId);
        //TODO IMPLEMENTA BASE RESPONSE
        return "Deleted student whit id - " + studentId;
    }

}
