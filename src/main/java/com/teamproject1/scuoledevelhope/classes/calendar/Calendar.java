package com.teamproject1.scuoledevelhope.classes.calendar;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar extends Pagination {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<MeetingResponse> calendar = new ArrayList<>();

    public Calendar() {
    }

    public Calendar(HttpStatus httpStatus, String message, String description, int page, int pageSize, long totalElements, int totalPages, LocalDate startDate, LocalDate endDate, List<MeetingResponse> calendar) {
        super(httpStatus, message, description, page, pageSize, totalElements, totalPages);
        this.startDate = startDate;
        this.endDate = endDate;
        this.calendar = calendar;
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


    public static final class CalendarBuilder {
        private LocalDate startDate;
        private LocalDate endDate;
        private List<MeetingResponse> calendar;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message;
        private String description;

        private CalendarBuilder() {
        }

        public static CalendarBuilder aCalendar() {
            return new CalendarBuilder();
        }

        public CalendarBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public CalendarBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public CalendarBuilder withCalendar(List<MeetingResponse> calendar) {
            this.calendar = calendar;
            return this;
        }

        public CalendarBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public CalendarBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public CalendarBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public CalendarBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public CalendarBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public CalendarBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public CalendarBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Calendar build() {
            Calendar calendar = new Calendar();
            calendar.setStartDate(startDate);
            calendar.setEndDate(endDate);
            calendar.setCalendar(this.calendar);
            calendar.setPage(page);
            calendar.setPageSize(pageSize);
            calendar.setTotalElements(totalElements);
            calendar.setTotalPages(totalPages);
            calendar.setHttpStatus(httpStatus);
            calendar.setMessage(message);
            calendar.setDescription(description);
            return calendar;
        }
    }
}
