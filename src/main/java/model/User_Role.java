package model;

import jakarta.persistence.Entity;

@Entity
public class User_Role {
    private Integer id_user;
    private Integer id_role;

    public Integer getId_user() {
        return id_user;
    }

    public Integer getId_role() {
        return id_role;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "id_user: " + id_user +
                ", id_role: " + id_role +
                '}';
    }
}
