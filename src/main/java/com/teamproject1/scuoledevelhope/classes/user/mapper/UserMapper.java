package com.teamproject1.scuoledevelhope.classes.user.mapper;

import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserAdd;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }

    public List<UserDto> userDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(userToUserDto(user));
        }
        return userDtoList;
    }

    public User userDtoToUser(UserDto userDto) {
        return User.UserBuilder.anUser()
                .withId(userDto.getId())
                .withUsername(userDto.getUsername())
                .build();
    }

    public UserAdd toUserAdd(User user) {
        return UserAdd.UserAddBuilder.anUserAdd()
                .withUsername(user.getUsername())
                .withName(user.getUserRegistry().getName())
                .withEmail(user.getUserRegistry().getEmail())
                .withPhoneNumber(user.getUserRegistry().getTelephone())
                .withPassword(user.getPassword())
                .build();
    }

}
