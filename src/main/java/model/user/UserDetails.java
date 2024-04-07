package model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @OneToOne
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "id")
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
        return "UserDetails{" +
                "user: " + user +
                ", name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", email: '" + email + '\'' +
                ", telephone: " + telephone +
                '}';
    }
}
