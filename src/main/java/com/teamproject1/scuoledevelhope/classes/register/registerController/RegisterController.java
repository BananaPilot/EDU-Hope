package com.teamproject1.scuoledevelhope.classes.register.registerController;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.registerService.RegisterService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/get-all")
    public BaseResponseList<Register> findAll(){
        return registerService.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    public BaseResponseElement<Register> findById(@PathVariable Integer id){
        return registerService.findById(id);
    }

    @GetMapping("/get-by-year/{year}")
    public BaseResponseList<Register> getAllBySchoolYear(@PathVariable String schoolYear){
        return registerService.getAllBySchoolYear(schoolYear);
    }

    @GetMapping("/get-by-tutor/{tutor}")
    public BaseResponseList<Register> getAllByTutor(@PathVariable Integer tutor){
        return registerService.getAllByTutor(tutor);
    }

    @PostMapping("/save")
    public BaseResponseElement<Register> save(@RequestBody Register register){
        return registerService.save(register);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public BaseResponseElement<Register> delete(@PathVariable Integer id){
        return registerService.deleteById(id);
    }

}
