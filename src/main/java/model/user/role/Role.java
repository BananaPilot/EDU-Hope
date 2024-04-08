package model.user.role;

import jakarta.persistence.*;
import model.user.User;

import java.util.Set;

@Entity
@Table(name = "role")
public enum Role {
    SUPER_ADMIN,
    ADMIN,
    COORDINATOR,
    TUTOR,
    STUDENT;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer id;
    @ManyToMany(
            mappedBy = "roles",
            fetch = FetchType.LAZY)
    private Set<User> users;

    public Integer getId() {
        return id;
    }
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "users: " + users +
                '}';
    }
}
