package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDtoList;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDTO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDtoList;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RegisterDTO {
    private String schoolYear;
    private Long tutorId;
    private String nameClass;
    private List<StudentDto> students;
    private List<VoteDTO> votes;

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

    public List<VoteDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDTO> votes) {
        this.votes = votes;

    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public static final class RegisterDTOBuilder {
        private String schoolYear;
        private Long tutorId;
        private String nameClass;
        private List<StudentDto> students;
        private List<VoteDTO> votes;

        private RegisterDTOBuilder() {
        }

        public static RegisterDTOBuilder aRegisterDTO() {
            return new RegisterDTOBuilder();
        }

        public RegisterDTOBuilder withSchoolYear(String schoolYear) {
            this.schoolYear = schoolYear;
            return this;
        }

        public RegisterDTOBuilder withTutorId(Long tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public RegisterDTOBuilder withNameClass(String nameClass) {
            this.nameClass = nameClass;
            return this;
        }

        public RegisterDTOBuilder withStudents(List<StudentDto> students) {
            this.students = students;
            return this;
        }

        public RegisterDTOBuilder withVotes(List<VoteDTO> votes) {
            this.votes = votes;
            return this;
        }

        public RegisterDTO build() {
            RegisterDTO registerDTO = new RegisterDTO();
            registerDTO.setSchoolYear(schoolYear);
            registerDTO.setTutorId(tutorId);
            registerDTO.setNameClass(nameClass);
            registerDTO.setStudents(students);
            registerDTO.setVotes(votes);
            return registerDTO;
        }
    }
}
