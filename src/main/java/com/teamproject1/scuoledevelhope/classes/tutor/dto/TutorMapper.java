package com.teamproject1.scuoledevelhope.classes.tutor.dto;

import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;

public class TutorMapper {

    private final UserMapper userMapper = new UserMapper();

    public TutorDto tutorToTutorDto(Tutor tutor) {
        return TutorDto.TutorDtoBuilder.aTutorDto()
                .withUser(userMapper.userToUserDto(tutor.getUser()))
                .build();
    }
}
