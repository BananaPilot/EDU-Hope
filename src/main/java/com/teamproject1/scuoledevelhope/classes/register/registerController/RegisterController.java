package com.teamproject1.scuoledevelhope.classes.register.registerController;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.registerService.RegisterService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //READ
    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-all")
    public BaseResponseList<Register> findAll() {
        return registerService.findAll();
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-by-id")
    public BaseResponseElement<Register> findById(@Valid @RequestParam Long id) {
        return registerService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "TUTOR")
    @GetMapping("/get-by-year")
    public BaseResponseList<Register> getAllBySchoolYear(@Valid @RequestParam String schoolYear) {
        return registerService.getAllBySchoolYear(schoolYear);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/get-by-tutor")
    public BaseResponseList<Register> getAllByTutor(@Valid @RequestParam Long tutor) {
        return registerService.getAllByTutor(tutor);
    }

    //ADD - UPDATE
    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<Register> save(@Valid @RequestBody Register register) {
        return registerService.save(register);
    }

    //DELETE
    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Register> delete(@Valid @RequestParam Long id) {
        return registerService.deleteById(id);
    }

}
