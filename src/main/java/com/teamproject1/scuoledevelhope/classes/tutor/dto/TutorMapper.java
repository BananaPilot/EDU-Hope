package com.teamproject1.scuoledevelhope.classes.tutor.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TutorMapper {

    private final UserMapper userMapper = new UserMapper();

    private final ClassRegisterMapper classRegisterMapper;

    public TutorMapper(ClassRegisterMapper classRegisterMapper) {

        this.classRegisterMapper = classRegisterMapper;
    }

    public TutorDto tutorToTutorDto(Tutor tutor) {
        return TutorDto.TutorDtoBuilder.aTutorDto()
                .withUser(userMapper.userToUserDto(tutor.getUser()))
                .withClasses(tutor.getClasses() != null ? classRegisterMapper.toListOfClassRegisterDto(tutor.getClasses()) : null)
                .build();
    }


    public List<TutorDto> toListTutorDto(List<Tutor> tutors) {
        List<TutorDto> toReturn = new ArrayList<>();
        for (Tutor tutor : tutors) {
            toReturn.add(this.tutorToTutorDto(tutor));
        }
        return toReturn;
    }

    public Tutor userToTutor(User user) {
        return Tutor.TutorBuilder.aTutor()
                .withUser(user)
                .build();
    }
}
