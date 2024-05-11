package com.teamproject1.scuoledevelhope.classes.user;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is needed to create a user")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is needed to create a user")
    private String password;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToOne
    @JoinColumn(name = "user_registry_id")
    private UserRegistry userRegistry;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(
            mappedBy = "users",
            fetch = FetchType.LAZY
    )
    private List<Role> roles;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(
            mappedBy = "users",
            fetch = FetchType.LAZY
    )
    public List<Meeting> meetings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistry getUserRegistry() {
        return userRegistry;
    }

    public List<Role> getRoles() {
        return roles;
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
        private List<Role> roles;

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

        public UserBuilder withRoles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.roles = this.roles;
            user.id = this.id;
            return user;
        }
    }
}
