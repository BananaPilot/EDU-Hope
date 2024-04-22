package com.teamproject1.scuoledevelhope.types.mappers;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.types.dtos.UserRegistryDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRegistryMapper {

    public UserRegistryDTO toUserRegistryDTO(UserRegistry userRegistry){

        UserRegistryDTO urDTO = new UserRegistryDTO();
        urDTO.setName(userRegistry.getName());
        urDTO.setSurname(userRegistry.getSurname());
        urDTO.setEmail(userRegistry.getEmail());

        return urDTO;
    }
}
