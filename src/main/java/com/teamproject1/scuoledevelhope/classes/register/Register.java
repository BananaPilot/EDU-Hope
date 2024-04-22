package com.teamproject1.scuoledevelhope.classes.register;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register")
    private Long id;
    @NotBlank(message = "school year can't be blank")
    @Column(
            name = "register_school-year",
            nullable = false)
    private String schoolYear;

    @OneToOne
    @JoinColumn(name = "id_class")
    private Classes schoolClass;
    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    @OneToMany(
            mappedBy = "register",
            fetch = FetchType.LAZY)
    private List<Vote> votes;
    @OneToMany(
            mappedBy = "register",
            fetch = FetchType.LAZY)
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolClass(Classes schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Classes getSchoolClass() {
        return schoolClass;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
