package model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes cl;
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Classes getCl() {
        return cl;
    }

    public Register getRegister() {
        return register;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id +
                ", id_user: " + user +
                ", id_class: " + cl +
                ", id_register: " + register +
                '}';
    }
}
