package com.teamproject1.scuoledevelhope.classes.school.schoolController;

import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.schoolService.SchoolService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/school")
public class SchoolController {

    SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/get-all")
    public BaseResponseList<School> findAll(){
        return schoolService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<School> findById(@RequestParam UUID id){
        return schoolService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<School> save(@RequestBody School school){
        return schoolService.save(school);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<School> delete(@RequestParam UUID id){
        return schoolService.deleteById(id);
    }
}
