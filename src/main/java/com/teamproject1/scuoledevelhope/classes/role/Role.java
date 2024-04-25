package com.teamproject1.scuoledevelhope.classes.role;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @Column(name = "role_name", unique = true)
    @Enumerated(EnumType.STRING)
    RoleEnum roleEnum;

    @ManyToMany(
            mappedBy = "roles",
            fetch = FetchType.LAZY
    )
    private List<User> users;

    public enum RoleEnum {
        SUPER_ADMIN,
        ADMIN,
        MODERATOR,
        USER,
        COORDINATOR,
        TUTOR,
        STUDENT

    }

    public Long getId() {
        return id;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public List<User> getUsers() {
        return users;
    }
}
