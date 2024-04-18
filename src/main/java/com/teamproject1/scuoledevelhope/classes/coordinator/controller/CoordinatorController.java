package com.teamproject1.scuoledevelhope.classes.coordinator.controller;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.service.CoordinatorService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/coordinator")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @GetMapping("/get-all")
    public BaseResponseList<Coordinator> findAll() {
        return coordinatorService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<Coordinator> findById(@RequestParam UUID id) {
        return coordinatorService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<Coordinator> save(@RequestBody Coordinator coordinator) {
        return coordinatorService.save(coordinator);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Coordinator> delete(@RequestParam UUID id) {
        return coordinatorService.deleteById(id);
    }
}
