package com.teamproject1.scuoledevelhope.classes.student.dto;

import com.teamproject1.scuoledevelhope.classes.classes.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDto;

public class StudentDto {
    private final UserDto user;
    private final ClassRegisterDTO schoolClass;

    public StudentDto(UserDto user, ClassRegisterDTO schoolClass) {
        this.user = user;
        this.schoolClass = schoolClass;
    }

    public UserDto getUser() {
        return user;
    }

    public ClassRegisterDTO getSchoolClass() {
        return schoolClass;
    }


    public static final class StudentDtoBuilder {
        private UserDto user;
        private ClassRegisterDTO schoolClass;

        private StudentDtoBuilder() {
        }

        public static StudentDtoBuilder aStudentDto() {
            return new StudentDtoBuilder();
        }

        public StudentDtoBuilder withUser(UserDto user) {
            this.user = user;
            return this;
        }

        public StudentDtoBuilder withSchoolClass(ClassRegisterDTO schoolClass) {
            this.schoolClass = schoolClass;
            return this;
        }

        public StudentDto build() {
            return new StudentDto(user, schoolClass);
        }
    }
}