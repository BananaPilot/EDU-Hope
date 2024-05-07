package com.teamproject1.scuoledevelhope.classes.user.dto;

import com.teamproject1.scuoledevelhope.types.dtos.BaseResponse;
import org.springframework.http.HttpStatus;

public class UserDtoElement extends BaseResponse {

    private UserDto user;

    public UserDtoElement() {
    }

    public UserDtoElement(HttpStatus httpStatus, String message, String description, UserDto user) {
        super(httpStatus, message, description);
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public static final class UserDtoElementBuilder {
        private UserDto user;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private UserDtoElementBuilder() {
        }

        public static UserDtoElementBuilder anUserDtoElement() {
            return new UserDtoElementBuilder();
        }

        public UserDtoElementBuilder withUserDto(UserDto userDto) {
            this.user = userDto;
            return this;
        }

        public UserDtoElementBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public UserDtoElementBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public UserDtoElementBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public UserDtoElement build() {
            return new UserDtoElement(httpStatus, message, description, user);
        }
    }
}
