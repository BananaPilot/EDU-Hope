package com.teamproject1.scuoledevelhope.classes.coordinator.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorDto;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorDtoList;
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
    public CoordinatorDtoList findAll(@RequestParam int limit, int page) {
        return coordinatorService.findAll(limit, page);
    }


    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/{id}")
    public BaseResponseElement<CoordinatorDto> findById(@PathVariable("id") Long id) {
        return coordinatorService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PostMapping("/save/{username}")
    public BaseResponseElement<CoordinatorDto> save(@PathVariable String username) {
        return coordinatorService.save(username);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @DeleteMapping("/{id}")
    public BaseResponseElement<CoordinatorDto> delete(@PathVariable Long id) {
        return coordinatorService.deleteById(id);
    }
}

