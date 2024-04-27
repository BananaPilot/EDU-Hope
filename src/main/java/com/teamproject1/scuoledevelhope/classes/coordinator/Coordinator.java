package com.teamproject1.scuoledevelhope.classes.coordinator;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "coordinator")
public class Coordinator {
    @Id
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @MapsId
    private User user;
    @NotEmpty(message = "Associates at least 1 class.")
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY
    )
    private List<Classes> classes;

    @PreRemove
    private void preRemove() {
        classes.forEach(cla -> cla.setCoordinator(null));
    }

    public void setUser(User user) {
        this.user = user;
    }
}
