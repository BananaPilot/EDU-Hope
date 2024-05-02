package com.teamproject1.scuoledevelhope.classes.classP;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "class")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private Long id;

    @NotBlank(message = "Class name can't be blank")
    @Column(
            name = "class_name",
            nullable = false
    )
    private String name;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_coordinator")
    private Coordinator coordinator;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(
            mappedBy = "schoolClass",
            fetch = FetchType.LAZY
    )
    private List<Student> students;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(
            mappedBy = "schoolClass"
    )
    private Register registers;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
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

    public School getSchool() {
        return school;
    }

    public Register getRegisters() {
        return registers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void t(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}
