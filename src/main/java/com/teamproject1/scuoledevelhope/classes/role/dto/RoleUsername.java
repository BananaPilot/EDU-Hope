package com.teamproject1.scuoledevelhope.classes.role.dto;


import com.teamproject1.scuoledevelhope.classes.role.Role;

public class RoleUsername {
    private String username;
    private Role.RoleEnum roleEnum;

    public RoleUsername(String username, Role.RoleEnum roleEnum) {
        this.username = username;
        this.roleEnum = roleEnum;
    }

    public RoleUsername() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role.RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(Role.RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
