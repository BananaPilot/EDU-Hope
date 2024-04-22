package com.teamproject1.scuoledevelhope.classes.coordinator.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.service.CoordinatorService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coordinator")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/get-all")
    public BaseResponseList<Coordinator> findAll() {
        return coordinatorService.findAll();
    }


    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Coordinator> findById(@Valid @RequestParam Long id) {
        return coordinatorService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PostMapping("/save")
    public BaseResponseElement<Coordinator> save(@Valid @RequestBody Coordinator coordinator) {
        return coordinatorService.save(coordinator);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Coordinator> delete(@Valid @RequestParam Long id) {
        return coordinatorService.deleteById(id);
    }
}

