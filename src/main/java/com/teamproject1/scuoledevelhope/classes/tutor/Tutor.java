package com.teamproject1.scuoledevelhope.classes.tutor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    private Long id;

    @ManyToOne
    @MapsId
    private User user;

    @NotEmpty(message = "Associates at least 1 class.")
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY)
    private List<Classes> classes;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY)
    private List<Register> registers;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
