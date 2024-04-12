package com.teamproject1.scuoledevelhope.classes.student.studentCrontroller;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.studentService.StudentService;
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

    @PostMapping("/save")
    public BaseResponseElement<Student> save(@RequestBody Student theStudent){
        return studentService.save(theStudent);
    }

    @PostMapping("/updateById/{id}")
    public BaseResponseElement<Student> update(@PathVariable String id, @RequestBody Student theStudent  ){
        return studentService.update(id,theStudent);
    }

    @DeleteMapping("/deleteById")
    public BaseResponseElement<Student> delete(@RequestParam String id){

        return studentService.deleteById(UUID.fromString(id));
    }



}
