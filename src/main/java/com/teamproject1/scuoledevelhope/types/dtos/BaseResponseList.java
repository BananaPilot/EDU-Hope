package com.teamproject1.scuoledevelhope.types.dtos;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BaseResponseList<T> extends Pagination {

    List<T> elements;

    public BaseResponseList() {

    }

    public BaseResponseList(HttpStatus httpStatus, String message, String description, int page, int pageSize, long totalElements, int totalPages, List<T> elements) {
        super(httpStatus, message, description, page, pageSize, totalElements, totalPages);
        this.elements = elements;
    }

    public BaseResponseList(List<T> elements) {
        this.elements = elements;
    }

    public List<T> getElements() {
        return elements;
    }
}
