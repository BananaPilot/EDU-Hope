package com.teamproject1.scuoledevelhope.classes.user.mapper;

import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }

    public List<UserDto> userDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user: users) {
            userDtoList.add(userToUserDto(user));
        }
        return userDtoList;
    }

}
