package com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryController;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryService.UserRegistryService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user_registry")
public class UserRegistryController {

    UserRegistryService userRegistryService;
    @GetMapping("/get-all")
    public BaseResponseList<UserRegistry> findAll(){
        return userRegistryService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<UserRegistry> findById(@RequestParam UUID id){
        return userRegistryService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<UserRegistry> save(@RequestBody UserRegistry userRegistry){
        return userRegistryService.save(userRegistry);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<UserRegistry> delete(@RequestParam UUID id){
        return userRegistryService.deleteById(id);
    }
}
