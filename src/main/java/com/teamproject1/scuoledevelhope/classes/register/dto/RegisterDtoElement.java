package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.types.dtos.BaseResponse;
import org.springframework.http.HttpStatus;

public class RegisterDtoElement extends BaseResponse {
    private RegisterDto registerDto;

    public RegisterDto getRegisterDto() {
        return registerDto;
    }

    public void setRegisterDto(RegisterDto registerDto) {
        this.registerDto = registerDto;
    }


    public static final class RegisterDtoElementBuilder {
        private RegisterDto registerDto;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private RegisterDtoElementBuilder() {
        }

        public static RegisterDtoElementBuilder aRegisterDtoElement() {
            return new RegisterDtoElementBuilder();
        }

        public RegisterDtoElementBuilder withRegisterDto(RegisterDto registerDto) {
            this.registerDto = registerDto;
            return this;
        }

        public RegisterDtoElementBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public RegisterDtoElementBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public RegisterDtoElementBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RegisterDtoElement build() {
            RegisterDtoElement registerDtoElement = new RegisterDtoElement();
            registerDtoElement.setRegisterDto(registerDto);
            registerDtoElement.setHttpStatus(httpStatus);
            registerDtoElement.setMessage(message);
            registerDtoElement.setDescription(description);
            return registerDtoElement;
        }
    }
}
