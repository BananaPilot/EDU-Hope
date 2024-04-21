package com.teamproject1.scuoledevelhope.classes.userRegistry.mapper;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.dto.UrDtoNameSurname;

public class UserRegistryMapper {

    public UrDtoNameSurname toNameSurname(UserRegistry userRegistry){

        UrDtoNameSurname dto = new UrDtoNameSurname();
        dto.setName(userRegistry.getName());
        dto.setSurname(userRegistry.getSurname());
        return dto;
    }
}
