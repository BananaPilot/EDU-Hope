package com.teamproject1.scuoledevelhope.types;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "id_role")
    Long idRole;

    @Id
    @Column(name = "id_user")
    Long idUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole userRole)) return false;
        return Objects.equals(idRole, userRole.idRole) && Objects.equals(idUser, userRole.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, idUser);
    }
}
