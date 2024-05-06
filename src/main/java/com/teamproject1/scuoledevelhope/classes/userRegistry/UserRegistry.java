package com.teamproject1.scuoledevelhope.classes.userRegistry;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user_registry")
public class UserRegistry {

    @Id
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(
            name = "user_email",
            nullable = false,
            unique = true)
    private String email;

    @Pattern(regexp = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[7-90]|36[680]|33[3-90]|32[89])\\d{7}$")
    @Column(name = "user_telephone", unique = true)
    private String telephone;

    public Long getId() {
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
}
