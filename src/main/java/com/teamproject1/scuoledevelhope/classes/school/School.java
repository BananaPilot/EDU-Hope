package com.teamproject1.scuoledevelhope.classes.school;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "school")
public class School {

    @Id
    @Column(name = "id_school")
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes cl;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY)
    private Set<Classes> classes;

    public UUID getId() {
        return id;
    }

    public Classes getCl() {
        return cl;
    }

    public Course getCourse() {
        return course;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Scuola{" +
                "id: " + id +
                ", class: " + cl +
                ", course: " + course +
                ", user: " + user +
                '}';
    }
}
