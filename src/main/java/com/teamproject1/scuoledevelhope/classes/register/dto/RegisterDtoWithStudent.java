package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RegisterDtoWithStudent{
    private RegisterDto registerDto;
    private List<StudentDto> students;

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public RegisterDto getRegisterDto() {
        return registerDto;
    }

    public void setRegisterDto(RegisterDto registerDto) {
        this.registerDto = registerDto;
    }

    public static final class RegisterDtoWithStudentBuilder {
        private RegisterDto registerDto;
        private List<StudentDto> students;

        private RegisterDtoWithStudentBuilder() {
        }

        public static RegisterDtoWithStudentBuilder aRegisterDtoWithStudent() {
            return new RegisterDtoWithStudentBuilder();
        }

        public RegisterDtoWithStudentBuilder withRegisterDto(RegisterDto registerDto) {
            this.registerDto = registerDto;
            return this;
        }

        public RegisterDtoWithStudentBuilder withStudents(List<StudentDto> students) {
            this.students = students;
            return this;
        }

        public RegisterDtoWithStudent build() {
            RegisterDtoWithStudent registerDtoWithStudent = new RegisterDtoWithStudent();
            registerDtoWithStudent.setStudents(students);
            registerDtoWithStudent.registerDto = this.registerDto;
            return registerDtoWithStudent;
        }
    }
}
