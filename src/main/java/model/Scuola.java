package model;

import jakarta.persistence.*;

@Entity
public class Scuola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes cl;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Integer getId() {
        return id;
    }

    public Classes getC() {
        return cl;
    }

    public Course getCourse() {
        return course;
    }

    public Register getRegister() {
        return register;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Scuola{" +
                "id: " + id +
                ", class: " + cl +
                ", course: " + course +
                ", user: " + user +
                '}';
    }
}
