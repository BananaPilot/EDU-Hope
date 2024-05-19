package com.teamproject1.scuoledevelhope.classes.report;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    private Long id;

    @Column(name = "conduct")
    private Float conduct;

    @Column(name = "grade_point_average")
    private Float gradePointAverage;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @Column(name = "subject")
    private String subject;

    public Long getId() {
        return id;
    }

    public Float getConduct() {
        return conduct;
    }

    public void setConduct(Float conduct) {
        this.conduct = conduct;
    }

    public Float getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(Float gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    public static final class ReportBuilder {
        private Long id;
        private Float conduct;
        private Float gradePointAverage;
        private Student student;
        private String subject;

        private ReportBuilder() {
        }

        public static ReportBuilder aReport() {
            return new ReportBuilder();
        }

        public ReportBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReportBuilder withConduct(Float conduct) {
            this.conduct = conduct;
            return this;
        }

        public ReportBuilder withGradePointAverage(Float gradePointAverage) {
            this.gradePointAverage = gradePointAverage;
            return this;
        }

        public ReportBuilder withStudent(Student student) {
            this.student = student;
            return this;
        }

        public ReportBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Report build() {
            Report report = new Report();
            report.setConduct(conduct);
            report.setGradePointAverage(gradePointAverage);
            report.setStudent(student);
            report.setSubject(subject);
            report.id = this.id;
            return report;
        }
    }
}
