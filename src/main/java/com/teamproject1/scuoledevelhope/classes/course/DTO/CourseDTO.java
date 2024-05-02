package com.teamproject1.scuoledevelhope.classes.course.DTO;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.school.School;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CourseDTO {
    @NotNull(message = "L'ID delcorso non può essere nullo")
    private Long courseId;
    @NotNull(message = "Il nome del corso non può essere nullo")
    private String name;
    @NotNull(message = "La descrizione del corso non può essere nulla")
    private String description;
    @NotNull(message = "L'ID relativo alla scuola che propone il corso non può essere nullo")
    private School schoolId;
    @NotNull(message = "La lista delle classi che seguono il corso non può essere nulla")
    private List<Classes> classes;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}
