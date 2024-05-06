package com.teamproject1.scuoledevelhope.classes.vote.dto;

import java.time.LocalDate;

public class VoteDTO {
    private Long idRegister;
    private Long idStudent;
    private LocalDate date;
    private String subject;
    private Float evaluation;
    private String annotation;
    private Boolean isCheckPoint;

    public VoteDTO() {
    }

    public Long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Long idRegister) {
        this.idRegister = idRegister;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Float evaluation) {
        this.evaluation = evaluation;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Boolean getIsCheckPoint() {
        return isCheckPoint;
    }
  
    public void setIsCheckPoint(Boolean isCheckPoint) {
        this.isCheckPoint = isCheckPoint;
    }


    public static final class VoteDTOBuilder {
        private Long idRegister;
        private Long idStudent;
        private LocalDate date;
        private String subject;
        private Float evaluation;
        private String annotation;
        private Boolean isCheckPoint;

        private VoteDTOBuilder() {
        }

        public static VoteDTOBuilder aVoteDTO() {
            return new VoteDTOBuilder();
        }

        public VoteDTOBuilder withIdRegister(Long idRegister) {
            this.idRegister = idRegister;
            return this;
        }

        public VoteDTOBuilder withIdStudent(Long idStudent) {
            this.idStudent = idStudent;
            return this;
        }

        public VoteDTOBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public VoteDTOBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public VoteDTOBuilder withEvaluation(Float evaluation) {
            this.evaluation = evaluation;
            return this;
        }

        public VoteDTOBuilder withAnnotation(String annotation) {
            this.annotation = annotation;
            return this;
        }

        public VoteDTOBuilder withIsCheckPoint(Boolean isCheckPoint) {
            this.isCheckPoint = isCheckPoint;
            return this;
        }

        public VoteDTO build() {
            VoteDTO voteDTO = new VoteDTO();
            voteDTO.setIdRegister(idRegister);
            voteDTO.setIdStudent(idStudent);
            voteDTO.setDate(date);
            voteDTO.setSubject(subject);
            voteDTO.setEvaluation(evaluation);
            voteDTO.setAnnotation(annotation);
            voteDTO.setIsCheckPoint(isCheckPoint);
            return voteDTO;
        }
    }
}
