package model;

import jakarta.persistence.*;

@Entity
public class UserAnagrafica {

    @Id
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    private String name;
    private String surname;
    @Column(nullable = false)
    private String email;
    private Long telephone;

    public User getUser() {
        return user;
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

    public Long getTelephone() {
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

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User_Anagrafica{" +
                "id_user: " + user +
                ", name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", email: '" + email + '\'' +
                ", telephone: " + telephone +
                '}';
    }
}
