package com.teamproject1.scuoledevelhope.classes.calendar.meeting;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_meeting")
    private UUID meetingID;

    @Column(name="title")
    private String title;
    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;
    @Column(name="link")
    private String link;
    @Column(name="note")
    private String note;

    @OneToOne
    @JoinColumn(name="tutor_id_fk")
    private Tutor tutorIDfk;
    @OneToOne
    @JoinColumn(name="coordinator_id_fk")
    private Coordinator coordinatorIDfk;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meeting_student",
            joinColumns = @JoinColumn(name = "id_meeting"),
            inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private Set<Student> students;

    public Meeting() {
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingID=" + meetingID +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", link='" + link + '\'' +
                ", note='" + note + '\'' +
                ", tutorIDfk=" + tutorIDfk +
                ", coordinatorIDfk=" + coordinatorIDfk +
                ", students=" + students +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Tutor getTutorIDfk() {
        return tutorIDfk;
    }

    public void setTutorIDfk(Tutor tutorIDfk) {
        this.tutorIDfk = tutorIDfk;
    }

    public Coordinator getCoordinatorIDfk() {
        return coordinatorIDfk;
    }

    public void setCoordinatorIDfk(Coordinator coordinatorIDfk) {
        this.coordinatorIDfk = coordinatorIDfk;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
