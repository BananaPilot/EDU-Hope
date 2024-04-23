package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MeetingService {

    private final MeetingDAO meetingDAO;

    public MeetingService(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    public BaseResponseList<Meeting> findAllById(Long id) {
        return new BaseResponseList<>(meetingDAO.getAllByID(id));
    }

    public BaseResponseList<Meeting> intervalGetById(Long id, LocalDate startDate, LocalDate endDate) {
        return new BaseResponseList<>(meetingDAO.intervalGetByID(id, startDate, endDate));
    }


    public BaseResponseElement<Meeting> save(Meeting meeting) {
        LocalDateTime start_date = meeting.getStartDate();
        LocalDateTime end_date = meeting.getEndDate();
        if (end_date.isAfter(start_date)) {
            throw new IllegalArgumentException("Hai confuso le date");
        }
        return new BaseResponseElement<Meeting>(meetingDAO.save(meeting));
    }
}
