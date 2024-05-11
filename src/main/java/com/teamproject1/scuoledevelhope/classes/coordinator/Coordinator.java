package com.teamproject1.scuoledevelhope.classes.coordinator;

import com.teamproject1.scuoledevelhope.classes.classes.Classes;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "coordinator")
public class Coordinator {

    @Id
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @MapsId
    private User user;

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(
            mappedBy = "coordinator",
            fetch = FetchType.LAZY
    )
    private List<Classes> classes;


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }


    public static final class CoordinatorBuilder {
        private Long id;
        private User user;
        private List<Classes> classes;

        private CoordinatorBuilder() {
        }

        public static CoordinatorBuilder aCoordinator() {
            return new CoordinatorBuilder();
        }

        public CoordinatorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CoordinatorBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public CoordinatorBuilder withClasses(List<Classes> classes) {
            this.classes = classes;
            return this;
        }

        public Coordinator build() {
            Coordinator coordinator = new Coordinator();
            coordinator.setUser(user);
            coordinator.setClasses(classes);
            coordinator.id = this.id;
            return coordinator;
        }
    }
}
