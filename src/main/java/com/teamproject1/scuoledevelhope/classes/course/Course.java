package com.teamproject1.scuoledevelhope.classes.course;

import jakarta.persistence.*;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.classP.Classes;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "course")
public enum Course {
    BACKEND,
    FULLSTACK,
    FRONTEND;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private UUID id;
    @Column(
            name = "course_name",
            nullable = false
    )
    private String name;
    @Column(name = "course_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;
    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY)
    private Set<Classes> classes;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public School getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", description: '" + description + '\'' +
                '}';
    }
}
