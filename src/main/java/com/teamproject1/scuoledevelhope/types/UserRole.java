package com.teamproject1.scuoledevelhope.types;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    Long id_role;
    @Id
    Long id_user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole userRole)) return false;
        return Objects.equals(id_role, userRole.id_role) && Objects.equals(id_user, userRole.id_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_role, id_user);
    }
}
