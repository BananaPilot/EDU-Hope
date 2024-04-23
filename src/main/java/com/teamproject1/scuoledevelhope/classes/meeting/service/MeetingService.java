package com.teamproject1.scuoledevelhope.classes.meeting.service;

import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingService {

    MeetingDAO meetingDAO;

    public MeetingService(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    public BaseResponseList<Meeting> getAllById(Long id) {
        return new BaseResponseList<>(meetingDAO.getAllById(id));
    }

    public BaseResponseList<Meeting> getByIntervalWithId(Long id, LocalDate startDate, LocalDate endDate) {
        return new BaseResponseList<>(meetingDAO.getMeetingsInInterval(id, startDate, endDate));
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
