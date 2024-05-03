package com.teamproject1.scuoledevelhope.classes.classP.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.service.ClassService;
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

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all")
    public BaseResponseList<Classes> findAll() {
        return classService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping
    public BaseResponseElement<Classes> findById(@RequestParam Long id) {
        return classService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<Classes> save(@Valid @RequestBody Classes classes) {
        return classService.save(classes);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete")
    public BaseResponseElement<Classes> delete(@Valid @RequestParam Long id) {
        return classService.deleteById(id);
    }


}
