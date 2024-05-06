package com.teamproject1.scuoledevelhope.classes.tutor.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDto;

import java.util.List;

public class TutorDto {
    private final UserDto user;
    private final List<ClassRegisterDTO> classes;

    public TutorDto(UserDto user, List<ClassRegisterDTO> classes) {
        this.user = user;
        this.classes = classes;
    }

    public UserDto getUser() {
        return user;
    }

    public List<ClassRegisterDTO> getClasses() {
        return classes;
    }


    public static final class TutorDtoBuilder {
        private UserDto user;
        private List<ClassRegisterDTO> classes;

        private TutorDtoBuilder() {
        }

        public static TutorDtoBuilder aTutorDto() {
            return new TutorDtoBuilder();
        }

        public TutorDtoBuilder withUser(UserDto user) {
            this.user = user;
            return this;
        }

        public TutorDtoBuilder withClasses(List<ClassRegisterDTO> classes) {
            this.classes = classes;
            return this;
        }

        public TutorDto build() {
            return new TutorDto(user, classes);
        }
    }
}