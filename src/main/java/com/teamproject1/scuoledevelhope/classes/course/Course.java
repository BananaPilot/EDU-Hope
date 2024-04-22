package com.teamproject1.scuoledevelhope.classes.course;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.school.School;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long id;

    @NotBlank(message = "Course name can't be blank")
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
    private EnumCourse enumCourse;
    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY)
    private List<Classes> classes;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public enum EnumCourse {
        BACKEND,
        FULLSTACK,
        FRONTEND
    }
}
