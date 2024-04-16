package com.teamproject1.scuoledevelhope.classes.tutor;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY)
    private Set<Classes> classes;
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY)
    private Set<Register> registers;

    public UUID getId() {
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
