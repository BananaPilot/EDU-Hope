package com.teamproject1.scuoledevelhope.classes.vote;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vote")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    @NotBlank(message = "date can't be blank")
    @Column(name = "vote_date",
            nullable = false)
    private LocalDate date;
    @NotBlank(message = "subject can't be blank")
    @Column(name = "subject")
    private String subject;
    @NotBlank(message = "evaluation can't be blank")
    @Column(name = "vote_evaluation",
            nullable = false)
    private Float evaluation;
    @Column(name = "annotation")
    private String annotation;
    private Boolean isCheckPoint;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Float getEvaluation() {
        return evaluation;
    }

    public String getAnnotation() {
        return annotation;
    }

    public Boolean getCheckPoint() {
        return isCheckPoint;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public void setCheckPoint(Boolean checkPoint) {
        isCheckPoint = checkPoint;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id_register: " + register +
                ", id_student: " + student +
                ", date: " + date +
                ", vote: " + evaluation +
                ", annotation: '" + annotation + '\'' +
                '}';
    }

}
