package com.teamproject1.scuoledevelhope.classes.school.dto;

import com.teamproject1.scuoledevelhope.classes.school.School;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public School toSchool(SchoolDto schoolDto){
        return School.SchoolBuilder.aSchool()
                .withName(schoolDto.getName())
                .build();
    }

    public SchoolDto toSchoolDto(School school){
        return SchoolDto.SchoolDtoBuilder.aSchoolDTO()
                .withName(school.getName())
                .build();
    }
}
