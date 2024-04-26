package com.teamproject1.scuoledevelhope.classes.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

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

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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

    @JsonBackReference
    public List<User> getUsers() {
        return users;
    }
}
