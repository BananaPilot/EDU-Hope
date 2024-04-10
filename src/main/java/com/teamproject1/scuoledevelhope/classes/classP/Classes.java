package com.teamproject1.scuoledevelhope.classes.classP;

import jakarta.persistence.*;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
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
    private Coordinator coordinator;
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;

    @OneToMany(
            mappedBy = "cl",
            fetch = FetchType.LAZY)
    private Set<Student> students;
    @OneToOne(mappedBy = "cl")
    private Register registers;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public Course getCourse() {
        return course;
    }

    public School getSchools() {
        return school;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Register getRegisters() {
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
