package com.teamproject1.scuoledevelhope.classes.student.dto;

import com.teamproject1.scuoledevelhope.classes.clazz.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    private final UserMapper userMapper = new UserMapper();

    private final ClassRegisterMapper classRegisterMapper;

    public StudentMapper(ClassRegisterMapper classRegisterMapper) {
        this.classRegisterMapper = classRegisterMapper;
    }

    public StudentDto toStudentDto(Student student) {
        return StudentDto.StudentDtoBuilder.aStudentDto()
                .withUser(userMapper.userToUserDto(student.getUser()))
                .withSchoolClass(student.getSchoolClass() != null ? classRegisterMapper.toClassRegisterDTO(student.getSchoolClass()) : null)
                .build();
    }

    public List<StudentDto> toListStudentDto(List<Student> students) {
        List<StudentDto> toReturn = new ArrayList<>();
        for (Student student : students) {
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
