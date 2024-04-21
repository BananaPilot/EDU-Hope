package com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.service;

import com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalendarService {

    MeetingDAO meetingDAO;

    public CalendarService(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    public BaseResponseElement<Calendar> intervalDate(LocalDate startDate, LocalDate endDate){


        Calendar calendar = new Calendar();
        return new BaseResponseElement<>(calendar);
    }
}
