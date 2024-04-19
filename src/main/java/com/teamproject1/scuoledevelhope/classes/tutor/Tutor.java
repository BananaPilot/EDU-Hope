package com.teamproject1.scuoledevelhope.classes.tutor;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Tutor name can't be blank")
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @NotEmpty(message = "Associates at least 1 class.")
    @Valid
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
