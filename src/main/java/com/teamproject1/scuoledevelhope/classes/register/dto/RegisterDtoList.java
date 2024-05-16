package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RegisterDtoList extends Pagination {
    private List<RegisterDto> registerDtoList;

    public List<RegisterDto> getRegisterDtoList() {
        return registerDtoList;
    }

    public void setRegisterDtoList(List<RegisterDto> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }


    public static final class RegisterDtoListBuilder {
        private List<RegisterDto> registerDtoList;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message;
        private String description;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;

        private RegisterDtoListBuilder() {
        }

        public static RegisterDtoListBuilder aRegisterDtoList() {
            return new RegisterDtoListBuilder();
        }

        public RegisterDtoListBuilder withRegisterDtoList(List<RegisterDto> registerDtoList) {
            this.registerDtoList = registerDtoList;
            return this;
        }

        public RegisterDtoListBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public RegisterDtoListBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public RegisterDtoListBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RegisterDtoListBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public RegisterDtoListBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public RegisterDtoListBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public RegisterDtoListBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public RegisterDtoList build() {
            RegisterDtoList registerDtoList = new RegisterDtoList();
            registerDtoList.setRegisterDtoList(this.registerDtoList);
            registerDtoList.setHttpStatus(httpStatus);
            registerDtoList.setMessage(message);
            registerDtoList.setDescription(description);
            registerDtoList.setPage(page);
            registerDtoList.setPageSize(pageSize);
            registerDtoList.setTotalElements(totalElements);
            registerDtoList.setTotalPages(totalPages);
            return registerDtoList;
        }
    }
}
