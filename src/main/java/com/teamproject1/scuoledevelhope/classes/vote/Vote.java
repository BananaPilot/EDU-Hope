package com.teamproject1.scuoledevelhope.classes.vote;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.report.Report;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vote")
    private Long id;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @PastOrPresent
    @Column(name = "vote_date",
            nullable = false)
    private LocalDate date;

    @NotBlank(message = "subject can't be blank")
    @Column(name = "vote_subject")
    private String subject;

    @Column(name = "vote_evaluation",
            nullable = false)
    private Float evaluation;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "is_check_point",
            columnDefinition = "TINYINT", length = 1)
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

    public Boolean getIsCheckPoint() {
        return isCheckPoint;
    }

    public Register getIdRegister() {
        return register;
    }

    public Student getIdStudent() {
        return student;
    }

    public void setIdRegister(Register register) {
        this.register = register;
    }

    public void setIdStudent(Student student) {
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

    public void setIsCheckPoint(Boolean isCheckPoint) {
        this.isCheckPoint = isCheckPoint;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public static final class VoteBuilder {
        private Long id;
        private Register register;
        private Student student;
        private @PastOrPresent LocalDate date;
        private @NotBlank(message = "subject can't be blank") String subject;
        private Float evaluation;
        private String annotation;
        private Boolean isCheckPoint;

        private VoteBuilder() {
        }

        public static VoteBuilder aVote() {
            return new VoteBuilder();
        }

        public VoteBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VoteBuilder withRegister(Register register) {
            this.register = register;
            return this;
        }

        public VoteBuilder withStudent(Student student) {
            this.student = student;
            return this;
        }

        public VoteBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public VoteBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public VoteBuilder withEvaluation(Float evaluation) {
            this.evaluation = evaluation;
            return this;
        }

        public VoteBuilder withAnnotation(String annotation) {
            this.annotation = annotation;
            return this;
        }

        public VoteBuilder withIsCheckPoint(Boolean isCheckPoint) {
            this.isCheckPoint = isCheckPoint;
            return this;
        }

        public Vote build() {
            Vote vote = new Vote();
            vote.setDate(date);
            vote.setSubject(subject);
            vote.setEvaluation(evaluation);
            vote.setAnnotation(annotation);
            vote.setIsCheckPoint(isCheckPoint);
            vote.id = this.id;
            vote.student = this.student;
            vote.register = this.register;
            return vote;
        }
    }
}
