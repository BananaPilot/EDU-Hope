package model.user.role.type;

import jakarta.persistence.*;
import model.school.classes.Classes;
import model.user.User;

import java.util.Set;

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
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY)
    private Set<Classes> classes;

    public Integer getId() {
        return id;
    }

    public User getId_user() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id: " + id +
                ", id_user: " + user +
                '}';
    }
}
