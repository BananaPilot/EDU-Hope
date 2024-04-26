package com.teamproject1.scuoledevelhope.classes.school;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_school")
    private Long id;
    @NotBlank(message = "School name can't be blank")
    @Column(
            name = "school_name",
            nullable = false)
    private String name;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY)
    private List<Classes> classes;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY)
    private List<Course> courses;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
