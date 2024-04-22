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
    private Long id;

    @ManyToOne
    @MapsId
    private User user;
    @NotEmpty(message = "Associates at least 1 class.")
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY)
    private List<Classes> classes;

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
