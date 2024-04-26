package com.teamproject1.scuoledevelhope.types.dtos;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BaseResponseList<T> extends BaseResponse {
    List<T> elements;

    public BaseResponseList() {

    }

    public BaseResponseList(HttpStatus httpStatus, String message, String description, List<T> elements) {
        super(httpStatus, message, description);
        this.elements = elements;
    }

    public BaseResponseList(List<T> elements) {
        this.elements = elements;
    }

    public List<T> getElements() {
        return elements;
    }
}
