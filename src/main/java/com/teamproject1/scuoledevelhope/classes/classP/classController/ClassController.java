package com.teamproject1.scuoledevelhope.classes.classP.classController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.classService.ClassService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public BaseResponseElement<Classes> findById(@Valid @RequestParam UUID id) {
        return classService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<Classes> save(@Valid @RequestBody Classes classes) {
        return classService.save(classes);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Classes> delete(@RequestParam UUID id) {
        return classService.deleteById(id);
    }
}
