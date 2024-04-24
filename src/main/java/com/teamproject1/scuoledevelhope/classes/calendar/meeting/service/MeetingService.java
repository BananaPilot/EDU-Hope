package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MeetingService {
    private final MeetingDAO meetingDAO;

    private final Utils utils;

    public MeetingService(MeetingDAO meetingDAO, Utils utils) {
        this.meetingDAO = meetingDAO;
        this.utils = utils;
    }

    public BaseResponseList<Meeting> getAllById(String jwt) {
        return new BaseResponseList<>(meetingDAO.getAllByID(getIdFromJwt(jwt)));
    }

    public Long getIdFromJwt(String jwt) {
        return utils.getUserFromJwt(jwt).getId();
    }

    public BaseResponseList<Meeting> intervalGetById(String jwt, LocalDate startDate, LocalDate endDate) {
        return new BaseResponseList<>(meetingDAO.intervalGetByID(getIdFromJwt(jwt), startDate, endDate));
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
