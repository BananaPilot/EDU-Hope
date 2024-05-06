package com.teamproject1.scuoledevelhope.classes.student.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    private final UserMapper userMapper = new UserMapper();

    @Autowired
    private ClassRegisterMapper classRegisterMapper;

    public StudentDto toStudentDto(Student student) {
        return StudentDto.StudentDtoBuilder.aStudentDto()
                .withUser(userMapper.userToUserDto(student.getUser()))
                .withSchoolClass(classRegisterMapper.toClassRegisterDTO(student.getSchoolClass()))
                .build();
    }

    public List<StudentDto> toStudentDtoList(List<Student> students) {
        List<StudentDto> toReturn = new ArrayList<>();
        for (Student student: students) {
            toReturn.add(this.toStudentDto(student));
        }
        return toReturn;
    }

    public Student userToStudent(User user) {
        return Student.StudentBuilder.aStudent()
                .withUser(user)
                .build();
    }
}
