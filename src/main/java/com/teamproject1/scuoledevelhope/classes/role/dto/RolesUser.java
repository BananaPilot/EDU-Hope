package com.teamproject1.scuoledevelhope.classes.role.dto;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDto;

import java.util.List;

public class RolesUser {
    private UserDto userDto;
    private List<Role.RoleEnum> roles;

    public RolesUser(List<Role.RoleEnum> roles, UserDto userDto) {
        this.roles = roles;
        this.userDto = userDto;
    }

    public List<Role.RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<Role.RoleEnum> roles) {
        this.roles = roles;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }


    public static final class RolesUserBuilder {
        private List<Role.RoleEnum> roles;
        private UserDto userDto;

        private RolesUserBuilder() {
        }

        public static RolesUserBuilder aRolesUser() {
            return new RolesUserBuilder();
        }

        public RolesUserBuilder withRoles(List<Role.RoleEnum> roles) {
            this.roles = roles;
            return this;
        }

        public RolesUserBuilder withUserDto(UserDto userDto) {
            this.userDto = userDto;
            return this;
        }

        public RolesUser build() {
            return new RolesUser(roles, userDto);
        }
    }
}
