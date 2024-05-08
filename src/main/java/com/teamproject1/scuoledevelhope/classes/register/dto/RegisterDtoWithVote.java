package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;

import java.util.List;

public class RegisterDtoWithVote {
    private String schoolYear;
    private Long tutorId;
    private String nameClass;
    private List<VoteDto> votes;

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


    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
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
        private List<VoteDto> votes;

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


        public RegisterDTOBuilder withVotes(List<VoteDto> votes) {
            this.votes = votes;
            return this;
        }

        public RegisterDtoWithVote build() {
            RegisterDtoWithVote registerDTO = new RegisterDtoWithVote();
            registerDTO.setSchoolYear(schoolYear);
            registerDTO.setTutorId(tutorId);
            registerDTO.setNameClass(nameClass);
            registerDTO.setVotes(votes);
            return registerDTO;
        }
    }
}
