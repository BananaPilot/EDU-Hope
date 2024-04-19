package com.teamproject1.scuoledevelhope.classes.coordinator;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "coordinator")
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_coordinator")
    private UUID id;
    @NotBlank(message = "Coordinator name can't be blank")
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @NotEmpty(message = "Associates at least 1 class.")
    @Valid
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY)
    private Set<Classes> classes;

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
