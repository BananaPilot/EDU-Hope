package com.teamproject1.scuoledevelhope.classes.course.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CourseWithClassesDto extends Pagination {
    private String name;
    private String courseDescription;
    private Long schoolId;
    private List<ClassRegisterDTO> classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public List<ClassRegisterDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassRegisterDTO> classes) {
        this.classes = classes;
    }


    public static final class CourseWithClassesDtoBuilder {
        private String name;
        private String courseDescription;
        private Long schoolId;
        private List<ClassRegisterDTO> classes;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message;
        private String description;

        private CourseWithClassesDtoBuilder() {
        }

        public static CourseWithClassesDtoBuilder aCourseWithClassesDto() {
            return new CourseWithClassesDtoBuilder();
        }

        public CourseWithClassesDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseWithClassesDtoBuilder withCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public CourseWithClassesDtoBuilder withSchoolId(Long schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public CourseWithClassesDtoBuilder withClasses(List<ClassRegisterDTO> classes) {
            this.classes = classes;
            return this;
        }

        public CourseWithClassesDtoBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public CourseWithClassesDtoBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public CourseWithClassesDtoBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public CourseWithClassesDtoBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public CourseWithClassesDtoBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public CourseWithClassesDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public CourseWithClassesDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CourseWithClassesDto build() {
            CourseWithClassesDto courseWithClassesDto = new CourseWithClassesDto();
            courseWithClassesDto.setName(name);
            courseWithClassesDto.setCourseDescription(courseDescription);
            courseWithClassesDto.setSchoolId(schoolId);
            courseWithClassesDto.setClasses(classes);
            courseWithClassesDto.setPage(page);
            courseWithClassesDto.setPageSize(pageSize);
            courseWithClassesDto.setTotalElements(totalElements);
            courseWithClassesDto.setTotalPages(totalPages);
            courseWithClassesDto.setHttpStatus(httpStatus);
            courseWithClassesDto.setMessage(message);
            courseWithClassesDto.setDescription(description);
            return courseWithClassesDto;
        }
    }
}
