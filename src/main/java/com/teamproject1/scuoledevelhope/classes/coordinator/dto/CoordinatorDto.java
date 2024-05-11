package com.teamproject1.scuoledevelhope.classes.coordinator.dto;

import com.teamproject1.scuoledevelhope.classes.clazzez.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDto;

import java.util.List;

public class CoordinatorDto {
    private final UserDto user;
    private final List<ClassRegisterDTO> classes;


    public CoordinatorDto(UserDto user, List<ClassRegisterDTO> classes) {
        this.user = user;
        this.classes = classes;
    }

    public UserDto getUser() {
        return user;
    }

    public List<ClassRegisterDTO> getClasses() {
        return classes;
    }


    public static final class CoordinatorDtoBuilder {
        private UserDto user;
        private List<ClassRegisterDTO> classes;

        private CoordinatorDtoBuilder() {
        }

        public static CoordinatorDtoBuilder aCoordinatorDto() {
            return new CoordinatorDtoBuilder();
        }

        public CoordinatorDtoBuilder withUser(UserDto user) {
            this.user = user;
            return this;
        }

        public CoordinatorDtoBuilder withClasses(List<ClassRegisterDTO> classes) {
            this.classes = classes;
            return this;
        }

        public CoordinatorDto build() {
            return new CoordinatorDto(user, classes);
        }
    }
}