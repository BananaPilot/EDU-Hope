package com.teamproject1.scuoledevelhope.classes.tutor.controller;

import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.service.TutorService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/get-all")
    public BaseResponseList<Tutor> findAll() {
        return tutorService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<Tutor> findById(@RequestParam UUID id) {
        return tutorService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<Tutor> save(@RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Tutor> delete(@RequestParam UUID id) {
        return tutorService.deleteById(id);
    }
}
