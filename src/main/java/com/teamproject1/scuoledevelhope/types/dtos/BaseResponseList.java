package com.teamproject1.scuoledevelhope.types.dtos;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BaseResponseList<T> extends BaseResponse {

    List<T> elements;

    private int page ;
    private int pageSize ;
    private long totalElements ;
    private int totalPages ;

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
