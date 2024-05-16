package com.teamproject1.scuoledevelhope.classes.clazzez.dto;

public class ClassRegisterDTO {

    private String className;
    private Long tutorId;
    private Long coordinatorId;
    private Long courseId;
    private Long schoolId;
    private String schoolYear;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Long coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }


    public static final class ClassRegisterDTOBuilder {
        private String className;
        private Long tutorId;
        private Long coordinatorId;
        private Long courseId;
        private Long schoolId;
        private String schoolYear;

        private ClassRegisterDTOBuilder() {
        }

        public static ClassRegisterDTOBuilder aClassRegisterDTO() {
            return new ClassRegisterDTOBuilder();
        }

        public ClassRegisterDTOBuilder withClassName(String className) {
            this.className = className;
            return this;
        }

        public ClassRegisterDTOBuilder withTutorId(Long tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public ClassRegisterDTOBuilder withCoordinatorId(Long coordinatorId) {
            this.coordinatorId = coordinatorId;
            return this;
        }

        public ClassRegisterDTOBuilder withCourseId(Long courseId) {
            this.courseId = courseId;
            return this;
        }

        public ClassRegisterDTOBuilder withSchoolId(Long schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public ClassRegisterDTOBuilder withSchoolYear(String schoolYear) {
            this.schoolYear = schoolYear;
            return this;
        }

        public ClassRegisterDTO build() {
            ClassRegisterDTO classRegisterDTO = new ClassRegisterDTO();
            classRegisterDTO.setClassName(className);
            classRegisterDTO.setTutorId(tutorId);
            classRegisterDTO.setCoordinatorId(coordinatorId);
            classRegisterDTO.setCourseId(courseId);
            classRegisterDTO.setSchoolId(schoolId);
            classRegisterDTO.setSchoolYear(schoolYear);
            return classRegisterDTO;
        }
    }
}
