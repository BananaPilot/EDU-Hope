package com.teamproject1.scuoledevelhope.classes.vote.dto;

import java.time.LocalDate;

public class VoteDTO {
    private Long idRegister;
    private Long idStudent;
    private LocalDate date;
    private String subject;
    private Float evaluation;
    private String annotation;
    private short isCheckPoint;

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

    public short getIsCheckPoint() {
        return isCheckPoint;
    }
  
    public void setIsCheckPoint(short isCheckPoint) {
        this.isCheckPoint = isCheckPoint;
    }
}
