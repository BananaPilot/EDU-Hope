package com.teamproject1.scuoledevelhope.classes.coordinator;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "coordinator")
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordinator")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY)
    private List<Classes> classes;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id: " + id +
                ", id_user: " + user +
                '}';
    }
}
