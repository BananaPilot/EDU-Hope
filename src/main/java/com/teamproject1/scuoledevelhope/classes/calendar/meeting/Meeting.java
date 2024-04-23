package com.teamproject1.scuoledevelhope.classes.calendar.meeting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meeting")
    private Long meetingID;

    @Column(name = "title")
    private String title;
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "link")
    private String link;
    @Column(name = "note")
    private String note;

    @JsonIgnore
    @JoinTable(
            name = "user_meeting",
            joinColumns = @JoinColumn(name = "id_meeting"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    @ManyToMany
    List<User> users;

    public Meeting() {
    }

    public Long getMeetingID() {
        return meetingID;
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

    public List<User> getUsers() {
        return users;
    }
}
