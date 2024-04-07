package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Vote {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    private String subject;
    private LocalDate date;
    private Float vote;
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

    public void setVote(Float vote) {
        this.vote = vote;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Float getVote() {
        return vote;
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
                ", vote: " + vote +
                ", annotation: '" + annotation + '\'' +
                '}';
    }
}
