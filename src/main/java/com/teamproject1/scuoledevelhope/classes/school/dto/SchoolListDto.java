package com.teamproject1.scuoledevelhope.classes.school.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class SchoolListDto extends Pagination {
    private List<SchoolDto> schoolDtoList;

    public List<SchoolDto> getSchoolDtoList() {
        return schoolDtoList;
    }

    public void setSchoolDtoList(List<SchoolDto> schoolDtoList) {
        this.schoolDtoList = schoolDtoList;
    }


    public static final class SchoolListDtoBuilder {
        private List<SchoolDto> schoolDtoList;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message;
        private String description;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;

        private SchoolListDtoBuilder() {
        }

        public static SchoolListDtoBuilder aSchoolListDto() {
            return new SchoolListDtoBuilder();
        }

        public SchoolListDtoBuilder withSchoolDtoList(List<SchoolDto> schoolDtoList) {
            this.schoolDtoList = schoolDtoList;
            return this;
        }

        public SchoolListDtoBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public SchoolListDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public SchoolListDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public SchoolListDtoBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public SchoolListDtoBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public SchoolListDtoBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public SchoolListDtoBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public SchoolListDto build() {
            SchoolListDto schoolListDto = new SchoolListDto();
            schoolListDto.setSchoolDtoList(schoolDtoList);
            schoolListDto.setHttpStatus(httpStatus);
            schoolListDto.setMessage(message);
            schoolListDto.setDescription(description);
            schoolListDto.setPage(page);
            schoolListDto.setPageSize(pageSize);
            schoolListDto.setTotalElements(totalElements);
            schoolListDto.setTotalPages(totalPages);
            return schoolListDto;
        }
    }
}
