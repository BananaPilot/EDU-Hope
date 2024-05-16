package com.teamproject1.scuoledevelhope.classes.role.dto;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;


public class RoleMapper {

    private final UserMapper userMapper = new UserMapper();


    public RolesUser toRolesUser(User user) {
        return RolesUser.RolesUserBuilder.aRolesUser()
                .withUserDto(userMapper.userToUserDto(user))
                .withRoles(toRoleEnumList(user.getRoles()))
                .build();
    }

    public List<Role.RoleEnum> toRoleEnumList(List<Role> roles) {
        List<Role.RoleEnum> toReturn = new ArrayList<>();

        for (Role role : roles) {
            toReturn.add(role.getRoleEnum());
        }

        return toReturn;
    }
}
