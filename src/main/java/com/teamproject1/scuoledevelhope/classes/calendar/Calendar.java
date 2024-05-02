package com.teamproject1.scuoledevelhope.classes.calendar;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar extends Pagination {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<MeetingResponse> calendar = new ArrayList<>();

    public Calendar() {
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

    public List<MeetingResponse> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<MeetingResponse> calendar) {
        this.calendar = calendar;
    }
}
