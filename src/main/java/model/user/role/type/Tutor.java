package model.user.role.type;

import jakarta.persistence.*;
import model.school.classes.Classes;
import model.school.classes.register.Register;
import model.user.User;

import java.util.Set;

@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutor")
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public Set<Register> getRegisters() {
        return registers;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id: " + id +
                ", id_user: " + user +
                '}';
    }
}
