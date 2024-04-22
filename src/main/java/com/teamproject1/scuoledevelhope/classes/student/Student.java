package com.teamproject1.scuoledevelhope.classes.student;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId
    private User user;
    @NotEmpty(message = "Associates at least 1 class.")
    @Valid
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes schoolClass;
    @NotEmpty(message = "Associates at least 1 register.")
    @Valid
    @ManyToOne
    @JoinColumn(name = "id_register")
    private Register register;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meeting_student",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_meeting")
    )
    private List<Meeting> meetings;

    public Student() {
    }

    public Student(User user, Classes schoolClass, Register register) {
        this.user = user;
        this.schoolClass = schoolClass;
        this.register = register;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public User getUser() {
        return user;
    }

    public Classes getSchoolClass() {
        return schoolClass;
    }

    public Register getRegister() {
        return register;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSchoolClass(Classes schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
