package com.teamproject1.scuoledevelhope.classes.course.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;

import java.util.List;

public class CourseWithClassesDto {
    private String name;
    private String description;
    private Long schoolId;
    private List<ClassRegisterDTO> classes;

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

    public List<ClassRegisterDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassRegisterDTO> classes) {
        this.classes = classes;
    }


    public static final class CourseWithClassesDtoBuilder {
        private String name;
        private String description;
        private Long schoolId;
        private List<ClassRegisterDTO> classes;

        private CourseWithClassesDtoBuilder() {
        }

        public static CourseWithClassesDtoBuilder aCourseWithClassesDto() {
            return new CourseWithClassesDtoBuilder();
        }

        public CourseWithClassesDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseWithClassesDtoBuilder withDescription(String description) {
            this.description = description;
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

        public CourseWithClassesDto build() {
            CourseWithClassesDto courseWithClassesDto = new CourseWithClassesDto();
            courseWithClassesDto.setName(name);
            courseWithClassesDto.setDescription(description);
            courseWithClassesDto.setSchoolId(schoolId);
            courseWithClassesDto.setClasses(classes);
            return courseWithClassesDto;
        }
    }
}
