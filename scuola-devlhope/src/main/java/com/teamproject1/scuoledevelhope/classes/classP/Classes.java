package com.teamproject1.scuoledevelhope.classes.classP;

import jakarta.persistence.*;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;

import java.util.Set;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private Integer id;
    @Column(
            name = "class_name",
            nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;
    @ManyToOne
    @JoinColumn(name = "id_coordinator")
    private Service coordinator;
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;
    @OneToMany(
            mappedBy = "cl",
            fetch = FetchType.LAZY)
    private Set<School> schools;
    @OneToMany(
            mappedBy = "cl",
            fetch = FetchType.LAZY)
    private Set<Student> students;
    @OneToMany(
            mappedBy = "cl",
            fetch = FetchType.LAZY)
    private Set<Register> registers;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Service getCoordinator() {
        return coordinator;
    }

    public Course getCourse() {
        return course;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Register> getRegisters() {
        return registers;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", tutor: " + tutor +
                ", coordinator: " + coordinator +
                ", course: " + course +
                '}';
    }
}
