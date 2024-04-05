package com.teamproject1.scuoledevelhope.types;

public class BaseResponseElement <T> extends BaseResponse {
    private T element;

    public BaseResponseElement() {

    }

    public BaseResponseElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
