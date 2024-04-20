package com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Meeting> calendar = new ArrayList<>();

    public Calendar() {
    }

    public Calendar(LocalDate startDate, LocalDate endDate, List<Meeting> calendar) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.calendar = calendar;
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

    public List<Meeting> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Meeting> calendar) {
        this.calendar = calendar;
    }
}
