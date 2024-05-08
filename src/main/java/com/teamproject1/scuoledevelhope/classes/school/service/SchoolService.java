package com.teamproject1.scuoledevelhope.classes.school.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.dto.SchoolDto;
import com.teamproject1.scuoledevelhope.classes.school.dto.SchoolListDto;
import com.teamproject1.scuoledevelhope.classes.school.dto.SchoolMapper;
import com.teamproject1.scuoledevelhope.classes.school.repo.SchoolDAO;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolDAO schoolDAO;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolDAO schoolDAO, SchoolMapper schoolMapper) {
        this.schoolDAO = schoolDAO;
        this.schoolMapper = schoolMapper;
    }

    public SchoolListDto findAll(int limit, int page) {
        Page<School> schoolDtoPage = schoolDAO.findAll(PageRequest.of(page, limit));
        return SchoolListDto.SchoolListDtoBuilder.aSchoolListDto()
                .withSchoolDtoList(schoolMapper.toListSchoolDto(schoolDtoPage.toList()))
                .withHttpStatus(HttpStatus.OK)
                .withPage(schoolDtoPage.getPageable().getPageNumber())
                .withPageSize(schoolDtoPage.getPageable().getPageSize())
                .withTotalElements(schoolDtoPage.getTotalElements())
                .withTotalPages(schoolDtoPage.getTotalPages())
                .build();

    }

    public BaseResponseElement<School> findById(Long id) {
        Optional<School> result = schoolDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("School was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<SchoolDto> save(SchoolDto schoolDto){
        SchoolDto school = schoolMapper.toSchoolDto(schoolDAO.save(schoolMapper.toSchool(schoolDto)));
        return new BaseResponseElement<>(school);
    }

    public BaseResponseElement<School> deleteById(Long id) {
        Optional<School> temp = schoolDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("School was not present");
        }
        schoolDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}
