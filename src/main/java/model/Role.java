package model;

import jakarta.persistence.Entity;

@Entity
public enum Role {
    SUPER_ADMIN,
    ADMIN,
    COORDINATOR,
    TUTOR,
    STUDENT
}
