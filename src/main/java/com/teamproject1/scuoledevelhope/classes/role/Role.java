package com.teamproject1.scuoledevelhope.classes.role;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private UUID id = UUID.randomUUID();

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    RoleEnum roleEnum;

    @ManyToMany(
            mappedBy = "roles",
            fetch = FetchType.LAZY
    )
    private Set<User> users;

    public UUID getId() {
        return id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public enum RoleEnum {
        SUPER_ADMIN,
        ADMIN,
        MODERATOR,
        USER,
        COORDINATOR,
        TUTOR,
        STUDENT;
    }

    @Override
    public String toString() {
        return "Role{" +
                "users: " + users +
                '}';
    }
}
