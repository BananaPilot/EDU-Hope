package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterDTO {


        private Date schoolYear;

        private long classId;

        private long tutorId;

        public RegisterDTO(Date schoolYear, long classId, long tutorId) {
            this.schoolYear = schoolYear;
            this.classId = classId;
            this.tutorId = tutorId;
        }

        public Date getSchoolYear() {
            return schoolYear;
        }

        public void setSchoolYear(Date schoolYear) {
            this.schoolYear = schoolYear;
        }

        public long getClassId() {
            return classId;
        }

        public void setClassId(long classId) {
            this.classId = classId;
        }

        public long getTutorId() {
            return tutorId;
        }

        public void setTutorId(long tutorId) {
            this.tutorId = tutorId;
        }

        public List<VoteDTO> getRegisterVoteDTO() {
            return registerVoteDTO;
        }

        public void setRegisterVoteDTO(List<VoteDTO> registerVoteDTO) {
            this.registerVoteDTO = registerVoteDTO;
        }

        List<VoteDTO> registerVoteDTO = new ArrayList<>();

    }


