package com.teamproject1.scuoledevelhope.classes.report;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

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


    public static final class ReportBuilder {
        private Long id;
        private Float conduct;
        private Float gradePointAverage;

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

        public Report build() {
            Report report = new Report();
            report.setConduct(conduct);
            report.setGradePointAverage(gradePointAverage);
            report.id = this.id;
            return report;
        }
    }
}
