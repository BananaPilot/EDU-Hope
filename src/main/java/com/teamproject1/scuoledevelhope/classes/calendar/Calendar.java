package com.teamproject1.scuoledevelhope.classes.calendar;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<MeetingResponse> calendar = new ArrayList<>();
    private int page;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    public Calendar() {
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
