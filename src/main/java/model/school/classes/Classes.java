package model.school.classes;

import jakarta.persistence.*;
import model.school.School;
import model.school.classes.course.Course;
import model.school.classes.register.Register;
import model.user.role.type.Coordinator;
import model.user.role.type.Student;
import model.user.role.type.Tutor;

import java.util.Set;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public Coordinator getCoordinator() {
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
