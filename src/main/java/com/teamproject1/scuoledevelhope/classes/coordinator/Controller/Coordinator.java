package com.teamproject1.scuoledevelhope.classes.coordinator.Controller;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;


@Entity
@Table(name = "coordinator")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordinator")
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