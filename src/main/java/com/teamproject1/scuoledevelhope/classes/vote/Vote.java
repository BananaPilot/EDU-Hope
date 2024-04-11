package com.teamproject1.scuoledevelhope.classes.vote;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import jakarta.persistence.*;
import com.teamproject1.scuoledevelhope.classes.student.Student;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @Column(name = "id_vote")
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    @Column(name = "vote_subject",
            nullable = false)
    private String subject;
    @Column(name = "vote_date",
            nullable = false)
    private LocalDate date;
    @Column(name = "vote_evaluation",
            nullable = false)
    private Float evaluation;
    @Column(name = "annotation")
    private String annotation;

    public Register getRegister() {
        return register;
    }

    public Student getStudent() {
        return student;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEvaluation(Float evaluation) {
        this.evaluation = evaluation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Float getEvaluation() {
        return evaluation;
    }

    public String getAnnotation() {
        return annotation;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id_register: " + register +
                ", id_student: " + student +
                ", subject: '" + subject + '\'' +
                ", date: " + date +
                ", vote: " + evaluation +
                ", annotation: '" + annotation + '\'' +
                '}';
    }
}
