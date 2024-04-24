package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MeetingService {
    private final MeetingDAO meetingDAO;
    private final MeetingMapper mapper;

    public MeetingService(MeetingDAO meetingDAO, MeetingMapper mapper) {
        this.meetingDAO = meetingDAO;
        this.mapper = mapper;
    }

    public BaseResponseList<Meeting> findAllById(Long id) {
        return new BaseResponseList<>(meetingDAO.getAllByID(id));
    }

    public BaseResponseList<Meeting> intervalGetById(Long id, LocalDate startDate, LocalDate endDate) {
        return new BaseResponseList<>(meetingDAO.intervalGetByID(id, startDate, endDate));
    }

    public BaseResponseElement<Meeting> save(Meeting meeting) {
        checkData(meeting);
        return new BaseResponseElement<Meeting>(meetingDAO.save(meeting));
    }

    public BaseResponseElement<MeetingDTO> updateMeeting(MeetingDTO meetingDTO){

        Meeting meeting = meetingDAO.save(mapper.toMeeting(meetingDTO));
        checkData(meeting);
        return new BaseResponseElement<>(mapper.toMeetingDTO(meeting));
    }

    public Meeting checkData(Meeting meeting){
        LocalDateTime start_date = meeting.getStartDate();
        LocalDateTime end_date = meeting.getEndDate();
        if (end_date.isBefore(start_date)) {
            throw new IllegalArgumentException("Hai confuso le date");
        }
        return meeting;
    }
}
