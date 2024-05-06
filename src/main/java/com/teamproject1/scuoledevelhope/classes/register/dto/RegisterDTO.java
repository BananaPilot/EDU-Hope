package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDtoList;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;

import java.util.List;

public class RegisterDTO extends Pagination {
    private String schoolYear;
    private Long tutorId;
    private String nameClass;
    private StudentDtoList studentDtoList;
    private VoteDtoList voteDtoList;

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

    public StudentDtoList getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(StudentDtoList studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

    public VoteDtoList getVoteDtoList() {
        return voteDtoList;
    }

    public void setVoteDtoList(VoteDtoList voteDtoList) {
        this.voteDtoList = voteDtoList;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
