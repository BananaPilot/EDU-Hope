package com.teamproject1.scuoledevelhope.classes.course;

import com.teamproject1.scuoledevelhope.classes.clazzez.Classes;
import com.teamproject1.scuoledevelhope.classes.school.School;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY
    )
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

    public School getSchool() {
        return school;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
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


    public static final class CourseBuilder {
        private Long id;
        private @NotBlank(message = "Course name can't be blank") String name;
        private String description;
        private School school;
        private List<Classes> classes;

        private CourseBuilder() {
        }

        public static CourseBuilder aCourse() {
            return new CourseBuilder();
        }

        public CourseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CourseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CourseBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CourseBuilder withSchool(School school) {
            this.school = school;
            return this;
        }

        public CourseBuilder withClasses(List<Classes> classes) {
            this.classes = classes;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.setName(name);
            course.setDescription(description);
            course.setSchool(school);
            course.classes = this.classes;
            course.id = this.id;
            return course;
        }
    }
}
