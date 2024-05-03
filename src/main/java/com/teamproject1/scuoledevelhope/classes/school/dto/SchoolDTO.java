package com.teamproject1.scuoledevelhope.classes.school.dto;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SchoolDTO {
    @NotNull(message = "L'ID della scuola non può essere nullo")
    private Long schoolId;
    @NotNull(message = "Il nome della scuola non può essere nullo")
    private String schoolName;
    @NotNull(message = "L'elenco delle classi della scuola non può essere nullo")
    private List<Classes> schoolClasses;
    @NotNull(message = "L'elenco dei corsi della scuola non può essere nullo")
    private List<Course> schoolCourses;
    @NotNull(message = "La lista degli utenti della scuola non può essere nulla")
    private List<User> schoolUsers;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Classes> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<Classes> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public List<Course> getSchoolCourses() {
        return schoolCourses;
    }

    public void setSchoolCourses(List<Course> schoolCourses) {
        this.schoolCourses = schoolCourses;
    }

    public List<User> getSchoolUsers() {
        return schoolUsers;
    }

    public void setSchoolUsers(List<User> schoolUsers) {
        this.schoolUsers = schoolUsers;
    }
}
