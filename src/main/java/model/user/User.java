package model.user;
import jakarta.persistence.*;
import model.school.School;
import model.user.role.type.Coordinator;
import model.user.role.Role;
import model.user.role.type.Student;
import model.user.role.type.Tutor;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(
            name = "user_name",
            nullable = false)
    private String name;

    @Column(
            name = "user_password",
            nullable = false)
    private String password;
    @Column(name = "user_details")
    @OneToOne(mappedBy = "user")
    private UserRegistry userDetails;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private Set<School> schools;
    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private Set<Student> students;
    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private Set<Tutor> tutors;
    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private Set<Coordinator> coordinators;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistry getUserDetails() {
        return userDetails;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Tutor> getTutors() {
        return tutors;
    }

    public Set<Coordinator> getCoordinators() {
        return coordinators;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", password: '" + password + '\'' +
                '}';
    }
}
