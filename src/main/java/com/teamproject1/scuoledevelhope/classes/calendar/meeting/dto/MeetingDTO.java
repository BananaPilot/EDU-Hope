package com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MeetingDTO {
    private Long meetingID;
    private String title;
    private String link;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String note;

    public MeetingDTO() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(Long meetingID) {
        this.meetingID = meetingID;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
