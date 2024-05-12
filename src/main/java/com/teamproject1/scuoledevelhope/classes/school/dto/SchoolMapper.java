package com.teamproject1.scuoledevelhope.classes.school.dto;

import com.teamproject1.scuoledevelhope.classes.school.School;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchoolMapper {

    public School toSchool(SchoolDto schoolDto) {
        return School.SchoolBuilder.aSchool()
                .withName(schoolDto.getName())
                .build();
    }

    public SchoolDto toSchoolDto(School school) {
        return SchoolDto.SchoolDtoBuilder.aSchoolDto()
                .withName(school.getName())
                .build();
    }

    public List<SchoolDto> toListSchoolDto(List<School> schools) {
        List<SchoolDto> schoolDtoList = new ArrayList<>();
        for (School element : schools) {
            schoolDtoList.add(this.toSchoolDto(element));
        }
        return schoolDtoList;
    }
}
