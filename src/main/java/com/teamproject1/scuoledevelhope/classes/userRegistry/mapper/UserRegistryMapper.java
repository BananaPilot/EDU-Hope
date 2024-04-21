package com.teamproject1.scuoledevelhope.classes.userRegistry.mapper;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.dto.UserRegistryDTO;
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
