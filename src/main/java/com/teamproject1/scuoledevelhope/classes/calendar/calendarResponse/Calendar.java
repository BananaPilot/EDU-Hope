package com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<MeetingDTO> calendar = new ArrayList<>();

    public Calendar() {
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", calendar=" + calendar +
                '}';
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<MeetingDTO> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<MeetingDTO> calendar) {
        this.calendar = calendar;
    }
}
