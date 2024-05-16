package com.teamproject1.scuoledevelhope.classes.course.dto;

public class CourseDto {

    private String name;
    private String description;
    private Long schoolId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }


    public static final class CourseDtoBuilder {
        private String name;
        private String description;
        private Long schoolId;

        private CourseDtoBuilder() {
        }

        public static CourseDtoBuilder aCourseDto() {
            return new CourseDtoBuilder();
        }

        public CourseDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CourseDtoBuilder withSchoolId(Long schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public CourseDto build() {
            CourseDto courseDto = new CourseDto();
            courseDto.setName(name);
            courseDto.setDescription(description);
            courseDto.setSchoolId(schoolId);
            return courseDto;
        }
    }
}
