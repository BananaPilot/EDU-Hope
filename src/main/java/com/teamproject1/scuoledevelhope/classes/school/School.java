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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_school")
    private UUID id;
    @Column(name = "school_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes schoolClass;

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

    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY)
    private Set<Course> courses;

    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY)
    private Set<User> users;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                '}';
    }
}
