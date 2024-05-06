package com.teamproject1.scuoledevelhope.classes.student.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class StudentDtoList extends Pagination {
    private List<StudentDto> students;

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public StudentDtoList() {
    }


    public static final class StudentDtoListBuilder {
        private List<StudentDto> students;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private StudentDtoListBuilder() {
        }

        public static StudentDtoListBuilder aStudentDtoList() {
            return new StudentDtoListBuilder();
        }

        public StudentDtoListBuilder withStudents(List<StudentDto> students) {
            this.students = students;
            return this;
        }

        public StudentDtoListBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public StudentDtoListBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public StudentDtoListBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public StudentDtoListBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public StudentDtoListBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public StudentDtoListBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public StudentDtoListBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public StudentDtoList build() {
            StudentDtoList studentDtoList = new StudentDtoList();
            studentDtoList.setStudents(students);
            studentDtoList.setPage(page);
            studentDtoList.setPageSize(pageSize);
            studentDtoList.setTotalElements(totalElements);
            studentDtoList.setTotalPages(totalPages);
            studentDtoList.setHttpStatus(httpStatus);
            studentDtoList.setMessage(message);
            studentDtoList.setDescription(description);
            return studentDtoList;
        }
    }
}
