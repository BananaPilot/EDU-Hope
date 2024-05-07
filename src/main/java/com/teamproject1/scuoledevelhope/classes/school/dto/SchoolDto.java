package com.teamproject1.scuoledevelhope.classes.school.dto;

public class SchoolDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final class SchoolDtoBuilder {
        private String name;

        private SchoolDtoBuilder() {
        }

        public static SchoolDtoBuilder aSchoolDTO() {
            return new SchoolDtoBuilder();
        }

        public SchoolDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SchoolDto build() {
            SchoolDto schoolDTO = new SchoolDto();
            schoolDTO.setName(name);
            return schoolDTO;
        }
    }
}
