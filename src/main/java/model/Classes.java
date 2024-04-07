package model;

import jakarta.persistence.*;

@Entity
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
