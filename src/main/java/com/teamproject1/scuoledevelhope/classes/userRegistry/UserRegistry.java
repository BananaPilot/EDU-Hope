package com.teamproject1.scuoledevelhope.classes.userRegistry;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_registry")
public class UserRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id = UUID.randomUUID();
    @OneToOne(mappedBy = "user")
    private User user;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_surname")
    private String surname;
    @Column(
            name = "user_email",
            nullable = false)
    private String email;
    @Column(name = "user_telephone")
    private String telephone;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "user: " + id +
                ", name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", email: '" + email + '\'' +
                ", telephone: " + telephone +
                '}';
    }

    @Embeddable
    public class UserRegistryId implements Serializable {
        private Long userId;
        private Long registryId; // Assegna un ID numerico a 'UserRegistry'

        public Long getUserId() {
            return userId;
        }

        public Long getRegistryId() {
            return registryId;
        }

        // ... getter e setter
    }
}
