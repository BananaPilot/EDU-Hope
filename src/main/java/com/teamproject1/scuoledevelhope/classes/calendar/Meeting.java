package com.teamproject1.scuoledevelhope.classes.calendar;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
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
    @Column(name="data")
    private LocalDateTime data;
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
    private List<Student> students;


    public Meeting() {
    }
    @Override
    public String toString() {
        return "Meeting{" +
                "meetingID=" + meetingID +
                ", title='" + title + '\'' +
                ", data=" + data +
                ", link='" + link + '\'' +
                ", note='" + note + '\'' +
                ", tutorIDfk='" + tutorIDfk + '\'' +
                ", coordinatorIDfk='" + coordinatorIDfk + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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

    public List<Student> getStudent() {
        return students;
    }

    public void setStudent(List<Student> student) {
        this.students = students;
    }
}
