package com.teamproject1.scuoledevelhope.classes.userRegistry.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.service.UserRegistryService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_registry")
public class UserRegistryController {

    private final UserRegistryService userRegistryService;

    public UserRegistryController(UserRegistryService userRegistryService) {
        this.userRegistryService = userRegistryService;
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-all")
    public BaseResponseList<UserRegistry> findAll() {
        return userRegistryService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-by-id")
    public BaseResponseElement<UserRegistry> findById(@Valid @RequestParam Long id) {
        return userRegistryService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<UserRegistry> save(@Valid @RequestBody UserRegistry userRegistry) {
        return userRegistryService.save(userRegistry);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<UserRegistry> delete(@Valid @RequestParam Long id) {
        return userRegistryService.deleteById(id);
    }
}
