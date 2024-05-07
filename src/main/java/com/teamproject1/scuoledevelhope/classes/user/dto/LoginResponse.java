package com.teamproject1.scuoledevelhope.classes.user.dto;

import com.teamproject1.scuoledevelhope.types.dtos.BaseResponse;
import org.springframework.http.HttpStatus;

public class LoginResponse extends BaseResponse {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }


    public static final class LoginResponseBuilder {
        private String element;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private LoginResponseBuilder() {
        }

        public static LoginResponseBuilder aLoginResponse() {
            return new LoginResponseBuilder();
        }

        public LoginResponseBuilder withElement(String element) {
            this.element = element;
            return this;
        }

        public LoginResponseBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public LoginResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public LoginResponseBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public LoginResponse build() {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setJwt(element);
            loginResponse.setHttpStatus(httpStatus);
            loginResponse.setMessage(message);
            loginResponse.setDescription(description);
            return loginResponse;
        }
    }
}
