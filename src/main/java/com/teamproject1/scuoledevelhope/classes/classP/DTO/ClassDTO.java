package com.teamproject1.scuoledevelhope.classes.classP.DTO;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ClassDTO {
    @NotNull(message = "L'ID della classe non può essere nullo")
    private Long classId;
    @NotNull(message = "Il nome della classe non può essere nullo")
    private String className;
    @NotNull(message = "L'ID del tutor della classe non può essere nullo")
    private Tutor tutorId;
    @NotNull(message = "L'ID del coordinatore della classe non può essere nullo")
    private Coordinator coordinatorId;
    @NotNull(message = "L'ID del coordinatore della classe non può essere nullo")
    private Course courseId;
    @NotNull(message = "L'ID della scuola della classe non può essere nullo")
    private School schoolId;
    @NotNull(message = "La lista degli studenti della classe non può avere un valore nullo")
    private List<Student> students;
    @NotNull(message = "L'ID del registro di classe non può essere nullo")
    private Register registerId;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setName(String name) {
        this.className = className;
    }

    public Tutor getTutorId() {
        return tutorId;
    }

    public void setTutorId(Tutor tutorId) {
        this.tutorId = tutorId;
    }

    public Coordinator getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Coordinator coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Register getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Register registerId) {
        this.registerId = registerId;
    }
}
