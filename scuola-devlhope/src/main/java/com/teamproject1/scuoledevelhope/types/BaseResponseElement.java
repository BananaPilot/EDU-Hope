package com.teamproject1.scuoledevelhope.types;

import org.springframework.http.HttpStatus;

public class BaseResponseElement <T> extends BaseResponse {
    private T element;

    public BaseResponseElement() {

    }

    public BaseResponseElement(HttpStatus httpStatus, String message, String description, T element) {
        super(httpStatus, message, description);
        this.element = element;
    }

    public BaseResponseElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
