package com.teamproject1.scuoledevelhope.classes.role.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.service.RoleService;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.RoleUsername;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @NoAuthorization
    @PostMapping("/addRole")
    public void addRoleSQL(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @PutMapping("/add")
    public BaseResponseElement<User> addRole(@RequestBody RoleUsername roleUsername) {
        return roleService.addRole(roleUsername);
    }

    @DeleteMapping("/add")
    public BaseResponseElement<User> deleteRole(@RequestBody RoleUsername roleUsername) {
        return roleService.deleteRole(roleUsername);
    }
}
