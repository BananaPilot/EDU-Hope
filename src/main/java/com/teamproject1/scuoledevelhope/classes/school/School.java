package com.teamproject1.scuoledevelhope.classes.school;

import com.teamproject1.scuoledevelhope.classes.clazzez.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
            nullable = false
    )
    private String name;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY
    )
    private List<Classes> classes;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY
    )
    private List<Course> courses;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(
            mappedBy = "school",
            fetch = FetchType.LAZY
    )
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


    public static final class SchoolBuilder {
        private @NotBlank(message = "School name can't be blank") String name;

        private Long id;
        private List<Classes> classes;
        private List<Course> courses;
        private List<User> users;

        private SchoolBuilder() {
        }

        public static SchoolBuilder aSchool() {
            return new SchoolBuilder();
        }

        public SchoolBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SchoolBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SchoolBuilder withClasses(List<Classes> classes) {
            this.classes = classes;
            return this;
        }

        public SchoolBuilder withCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public SchoolBuilder withUsers(List<User> users) {
            this.users = users;
            return this;
        }

        public School build() {
            School school = new School();
            school.setName(name);
            school.id = this.id;
            school.classes = this.classes;
            school.courses = this.courses;
            school.users = this.users;
            return school;
        }
    }
}
