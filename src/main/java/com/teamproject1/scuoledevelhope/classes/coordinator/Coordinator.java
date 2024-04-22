package com.teamproject1.scuoledevelhope.classes.coordinator;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "coordinator")
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordinator")

    @NotBlank(message = "Coordinator name can't be blank")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @NotEmpty(message = "Associates at least 1 class.")
    @Valid
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
