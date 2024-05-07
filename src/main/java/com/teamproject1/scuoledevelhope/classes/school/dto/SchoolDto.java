package com.teamproject1.scuoledevelhope.classes.school.dto;

public class SchoolDto {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public static final class SchoolDtoBuilder {
        private Long id;
        private String name;

        private SchoolDtoBuilder() {
        }

        public static SchoolDtoBuilder aSchoolDto() {
            return new SchoolDtoBuilder();
        }

        public SchoolDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SchoolDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SchoolDto build() {
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setName(name);
            schoolDto.id = this.id;
            return schoolDto;
        }
    }
}
