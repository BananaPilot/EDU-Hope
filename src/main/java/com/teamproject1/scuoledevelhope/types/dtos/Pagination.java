package com.teamproject1.scuoledevelhope.types.dtos;

import org.springframework.http.HttpStatus;

public class Pagination extends BaseResponse {

    public Pagination(HttpStatus httpStatus, String message, String description, int page, int pageSize, long totalElements, int totalPages) {
        super(httpStatus, message, description);
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public Pagination() {
    }

    private int page;
    private int pageSize;
    private long totalElements;
    private int totalPages;

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
