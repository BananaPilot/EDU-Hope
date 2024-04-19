package com.teamproject1.scuoledevelhope.classes.role;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_role")
    private UUID id;

    @NotBlank(message = "Role enum is needed to create the entity")
    @Column(name = "role_name", unique = true)
    @Enumerated(EnumType.STRING)
    RoleEnum roleEnum;

    public enum RoleEnum {
        SUPER_ADMIN,
        ADMIN,
        MODERATOR,
        USER,
        COORDINATOR,
        TUTOR,
        STUDENT;
    }

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

    @Override
    public String toString() {
        return "Role{" +
                "users: " + users +
                '}';
    }
}
