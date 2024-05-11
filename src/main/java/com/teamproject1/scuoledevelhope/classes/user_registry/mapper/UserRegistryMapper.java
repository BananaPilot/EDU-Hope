package com.teamproject1.scuoledevelhope.classes.user_registry.mapper;

import com.teamproject1.scuoledevelhope.classes.user_registry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.user_registry.dto.UserRegistryDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRegistryMapper {
    public UserRegistryDTO toUserRegistryDTO(UserRegistry userRegistry) {

        UserRegistryDTO urDTO = new UserRegistryDTO();
        urDTO.setName(userRegistry.getName());
        urDTO.setSurname(userRegistry.getSurname());
        urDTO.setEmail(userRegistry.getEmail());

        return urDTO;
    }
}
