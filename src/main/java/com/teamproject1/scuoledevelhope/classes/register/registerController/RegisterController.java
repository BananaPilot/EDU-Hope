package com.teamproject1.scuoledevelhope.classes.register.registerController;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.registerService.RegisterService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //READ
    @GetMapping("/get-all")
    public BaseResponseList<Register> findAll() {
        return registerService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<Register> findById(@RequestParam UUID id) {
        return registerService.findById(id);
    }

    @GetMapping("/get-by-year")
    public BaseResponseList<Register> getAllBySchoolYear(@RequestParam String schoolYear) {
        return registerService.getAllBySchoolYear(schoolYear);
    }

    @GetMapping("/get-by-tutor")
    public BaseResponseList<Register> getAllByTutor(@RequestParam UUID tutor) {
        return registerService.getAllByTutor(tutor);
    }

    //ADD - UPDATE
    @PostMapping("/save")
    public BaseResponseElement<Register> save(@RequestBody Register register) {
        return registerService.save(register);
    }

    //DELETE
    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Register> delete(@RequestParam UUID id) {
        return registerService.deleteById(id);
    }

}
