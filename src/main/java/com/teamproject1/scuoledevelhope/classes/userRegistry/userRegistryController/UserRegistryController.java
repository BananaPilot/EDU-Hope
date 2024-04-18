package com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryService.UserRegistryService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public BaseResponseElement<UserRegistry> findById(@RequestParam UUID id) {
        return userRegistryService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<UserRegistry> save(@RequestBody UserRegistry userRegistry) {
        return userRegistryService.save(userRegistry);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<UserRegistry> delete(@RequestParam UUID id) {
        return userRegistryService.deleteById(id);
    }
}
