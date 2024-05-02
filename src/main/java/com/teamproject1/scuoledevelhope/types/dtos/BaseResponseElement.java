package com.teamproject1.scuoledevelhope.types.dtos;

import org.springframework.http.HttpStatus;

public class BaseResponseElement<T> extends BaseResponse {
    private T element;
    private int page ;
    private int pageSize ;
    private long totalElements ;
    private int totalPages ;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
