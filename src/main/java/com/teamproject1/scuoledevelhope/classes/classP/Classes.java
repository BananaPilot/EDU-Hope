package com.teamproject1.scuoledevelhope.classes.classP;

import jakarta.persistence.*;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @Column(name = "id_class")
    private UUID id = UUID.randomUUID();
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
            mappedBy = "schoolClass",
            fetch = FetchType.LAZY)
    private Set<Student> students;
    @OneToOne(mappedBy = "schoolClass")
    private Register registers;

    public UUID getId() {
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

    public Register getRegisters() {
        return registers;
    }

    public School getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setRegisters(Register registers) {
        this.registers = registers;
    }

    public void setSchool(School school) {
        this.school = school;

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
