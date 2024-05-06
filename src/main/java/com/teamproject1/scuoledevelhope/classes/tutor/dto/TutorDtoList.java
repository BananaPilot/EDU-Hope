package com.teamproject1.scuoledevelhope.classes.tutor.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TutorDtoList extends Pagination {

    private List<TutorDto> tutors;

    public List<TutorDto> getTutors() {
        return tutors;
    }

    public void setTutors(List<TutorDto> tutors) {
        this.tutors = tutors;
    }

    public TutorDtoList() {
    }

    public static final class TutorDtoListBuilder {
        private List<TutorDto> tutors;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private TutorDtoListBuilder() {
        }

        public static TutorDtoListBuilder aTutorDtoList() {
            return new TutorDtoListBuilder();
        }

        public TutorDtoListBuilder withTutors(List<TutorDto> tutors) {
            this.tutors = tutors;
            return this;
        }

        public TutorDtoListBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public TutorDtoListBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public TutorDtoListBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public TutorDtoListBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public TutorDtoListBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public TutorDtoListBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public TutorDtoListBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TutorDtoList build() {
            TutorDtoList tutorDtoList = new TutorDtoList();
            tutorDtoList.setTutors(tutors);
            tutorDtoList.setPage(page);
            tutorDtoList.setPageSize(pageSize);
            tutorDtoList.setTotalElements(totalElements);
            tutorDtoList.setTotalPages(totalPages);
            tutorDtoList.setHttpStatus(httpStatus);
            tutorDtoList.setMessage(message);
            tutorDtoList.setDescription(description);
            return tutorDtoList;
        }
    }
}
