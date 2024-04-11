package com.teamproject1.scuoledevelhope.classes.register;

import jakarta.persistence.*;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;

import java.util.Set;

@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register")
    private Integer id;
    @Column(
            name = "register_school-year",
            nullable = false)
    private String schoolYear;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes cl;
    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    @OneToMany(
            mappedBy = "register",
            fetch = FetchType.LAZY)
    private Set<Vote> votes;
    @OneToMany(
            mappedBy = "register",
            fetch = FetchType.LAZY)
    private Set<School> schools;
    @OneToMany(
            mappedBy = "register",
            fetch = FetchType.LAZY)
    private Set<Student> students;

    public Integer getId() {
        return id;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public Classes getCl() {
        return cl;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id: " + id +
                ", schoolYear: '" + schoolYear + '\'' +
                ", id_class: " + cl +
                ", id_tutor: " + tutor +
                '}';
    }
}
