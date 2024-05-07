package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;

import java.util.List;

public class RegisterDtoWithStudent {

    private String schoolYear;
    private Long tutorId;
    private String nameClass;
    private List<StudentDto> students;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }


    public static final class RegisterDtoWithStudentBuilder {
        private String schoolYear;
        private Long tutorId;
        private String nameClass;
        private List<StudentDto> students;

        private RegisterDtoWithStudentBuilder() {
        }

        public static RegisterDtoWithStudentBuilder aRegisterDtoWithStudent() {
            return new RegisterDtoWithStudentBuilder();
        }

        public RegisterDtoWithStudentBuilder withSchoolYear(String schoolYear) {
            this.schoolYear = schoolYear;
            return this;
        }

        public RegisterDtoWithStudentBuilder withTutorId(Long tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public RegisterDtoWithStudentBuilder withNameClass(String nameClass) {
            this.nameClass = nameClass;
            return this;
        }

        public RegisterDtoWithStudentBuilder withStudents(List<StudentDto> students) {
            this.students = students;
            return this;
        }

        public RegisterDtoWithStudent build() {
            RegisterDtoWithStudent registerDtoWithStudent = new RegisterDtoWithStudent();
            registerDtoWithStudent.setSchoolYear(schoolYear);
            registerDtoWithStudent.setTutorId(tutorId);
            registerDtoWithStudent.setNameClass(nameClass);
            registerDtoWithStudent.setStudents(students);
            return registerDtoWithStudent;
        }
    }
}
