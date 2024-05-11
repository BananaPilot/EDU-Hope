package com.teamproject1.scuoledevelhope.classes.clazzez.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.clazzez.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.clazzez.dto.ClassRegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.clazzez.service.ClassService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/all")
    public ClassRegisterDtoList findAll(@RequestParam int limit, int page) {
        return classService.findAll(limit, page);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @GetMapping("/{id}")
    public BaseResponseElement<ClassRegisterDTO> findById(@PathVariable Long id) {
        return classService.findById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/save")
    public BaseResponseElement<ClassRegisterDTO> save(@RequestBody ClassRegisterDTO classRegisterDTO) {
        return classService.save(classRegisterDTO);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/{id}")
    public BaseResponseElement<ClassRegisterDTO> delete(@Valid @PathVariable Long id) {
        return classService.deleteById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PutMapping("/addClass")
    public BaseResponseElement<ClassRegisterDTO> addClassToUser(@RequestParam Long userId, Long classId) {
        return classService.addClassToUser(userId, classId);
    }
}
