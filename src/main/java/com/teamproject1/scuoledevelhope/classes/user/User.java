package com.teamproject1.scuoledevelhope.classes.user;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is needed to create a user")
    @Column(unique = true)
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    @NotBlank(message = "Password is needed to create a user")
    private String password;

    @OneToOne()
    @JoinColumn(
            name = "user_registry_id",
            referencedColumnName = "id"
    )
    private UserRegistry userRegistry;

    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;

    @ManyToMany
    private List<Role> roles;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Student> students;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Tutor> tutors;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Coordinator> coordinators;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public School getSchool() {
        return school;
    }

    public UserRegistry getUserRegistry() {
        return userRegistry;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final class UserBuilder {

        private Long id;
        private String username;
        private String password;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User(username, password);
            user.id = this.id;
            return user;
        }
    }
}
