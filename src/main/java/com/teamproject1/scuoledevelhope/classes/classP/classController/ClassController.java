package com.teamproject1.scuoledevelhope.classes.classP.classController;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.classService.ClassService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/get-all")
    public BaseResponseList<Classes> findAll() {
        return classService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<Classes> findById(@RequestParam UUID id) {
        return classService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<Classes> save(@RequestBody Classes classes) {
        return classService.save(classes);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Classes> delete(@RequestParam UUID id) {
        return classService.deleteById(id);
    }
}
