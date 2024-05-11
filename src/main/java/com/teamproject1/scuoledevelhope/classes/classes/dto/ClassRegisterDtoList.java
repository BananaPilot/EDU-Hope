package com.teamproject1.scuoledevelhope.classes.classes.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ClassRegisterDtoList extends Pagination {
    private List<ClassRegisterDTO> classes;

    public ClassRegisterDtoList() {

    }

    public List<ClassRegisterDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassRegisterDTO> classes) {
        this.classes = classes;
    }

    public static final class ClassRegisterDtoListBuilder {
        private List<ClassRegisterDTO> classes;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message;
        private String description;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;

        private ClassRegisterDtoListBuilder() {
        }

        public static ClassRegisterDtoListBuilder aClassRegisterDtoList() {
            return new ClassRegisterDtoListBuilder();
        }

        public ClassRegisterDtoListBuilder withClasses(List<ClassRegisterDTO> classes) {
            this.classes = classes;
            return this;
        }

        public ClassRegisterDtoListBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ClassRegisterDtoListBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ClassRegisterDtoListBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ClassRegisterDtoListBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public ClassRegisterDtoListBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ClassRegisterDtoListBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public ClassRegisterDtoListBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public ClassRegisterDtoList build() {
            ClassRegisterDtoList classRegisterDtoList = new ClassRegisterDtoList();
            classRegisterDtoList.setClasses(classes);
            classRegisterDtoList.setHttpStatus(httpStatus);
            classRegisterDtoList.setMessage(message);
            classRegisterDtoList.setDescription(description);
            classRegisterDtoList.setPage(page);
            classRegisterDtoList.setPageSize(pageSize);
            classRegisterDtoList.setTotalElements(totalElements);
            classRegisterDtoList.setTotalPages(totalPages);
            return classRegisterDtoList;
        }
    }
}
