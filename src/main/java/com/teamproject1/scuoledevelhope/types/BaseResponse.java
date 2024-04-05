package com.teamproject1.scuoledevelhope.types;

import org.springframework.http.HttpStatus;

public class BaseResponse {

    HttpStatus httpStatus = HttpStatus.OK;
    String message;
    String description;

    public BaseResponse() {

    }

    public BaseResponse(HttpStatus httpStatus, String message, String description) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.description = description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
