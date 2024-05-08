package com.teamproject1.scuoledevelhope.classes.register.dto;

public class RegisterDto {

    private String schoolYear;
    private Long tutorId;
    private String nameClass;

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

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }


    public static final class RegisterDtoBuilder {
        private String schoolYear;
        private Long tutorId;
        private String nameClass;

        private RegisterDtoBuilder() {
        }

        public static RegisterDtoBuilder aRegisterDto() {
            return new RegisterDtoBuilder();
        }

        public RegisterDtoBuilder withSchoolYear(String schoolYear) {
            this.schoolYear = schoolYear;
            return this;
        }

        public RegisterDtoBuilder withTutorId(Long tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public RegisterDtoBuilder withNameClass(String nameClass) {
            this.nameClass = nameClass;
            return this;
        }

        public RegisterDto build() {
            RegisterDto registerDto = new RegisterDto();
            registerDto.setSchoolYear(schoolYear);
            registerDto.setTutorId(tutorId);
            registerDto.setNameClass(nameClass);
            return registerDto;
        }
    }
}
