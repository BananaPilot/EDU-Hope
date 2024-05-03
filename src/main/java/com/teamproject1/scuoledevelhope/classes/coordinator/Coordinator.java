package com.teamproject1.scuoledevelhope.classes.coordinator;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "coordinator")
public class Coordinator {

    @Id
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @MapsId
    private User user;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @NotEmpty(message = "Associates at least 1 class.")
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY
    )
    private List<Classes> classes;


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Classes> getClasses() {
        return classes;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}
