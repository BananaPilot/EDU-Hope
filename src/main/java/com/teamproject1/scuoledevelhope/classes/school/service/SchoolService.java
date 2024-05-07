package com.teamproject1.scuoledevelhope.classes.school.service;

import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.dto.SchoolDto;
import com.teamproject1.scuoledevelhope.classes.school.dto.SchoolMapper;
import com.teamproject1.scuoledevelhope.classes.school.repo.SchoolDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolDAO schoolDAO;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolDAO schoolDAO, SchoolMapper schoolMapper) {
        this.schoolDAO = schoolDAO;
        this.schoolMapper = schoolMapper;
    }

    public BaseResponseList<School> findAll() {
        return new BaseResponseList<>(schoolDAO.findAll());
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
