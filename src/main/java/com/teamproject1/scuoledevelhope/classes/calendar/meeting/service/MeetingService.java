package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.http.HttpStatus;
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

    //tutti i meeting di un user
    public BaseResponseList<Meeting> allMeetingByUser(Long id) {
        return new BaseResponseList<>(meetingDAO.allMeetingByUser(id));
    }

    //tutti i meeting di un user in un intervallo di tempo
    public BaseResponseList<Meeting> intervalGetById(Long id, LocalDate startDate, LocalDate endDate) {
        return new BaseResponseList<>(meetingDAO.intervalGetByID(id, startDate, endDate));
    }

    public BaseResponseElement<Meeting> save(Meeting meeting) {
        meeting.setMeetingID(null);
        checkData(meeting);
        return new BaseResponseElement<Meeting>(HttpStatus.CREATED,HttpStatus.CREATED.getReasonPhrase(),"data saving successful",meetingDAO.save(meeting));
    }

    public BaseResponseElement<MeetingDTO> updateMeeting(MeetingDTO meetingDTO){

        Meeting meeting = meetingDAO.save(mapper.toMeeting(meetingDTO));
        checkData(meeting);
        return new BaseResponseElement<>(HttpStatus.OK,HttpStatus.OK.getReasonPhrase(),"data updated correctly",mapper.toMeetingDTO(meeting));
    }

    public Meeting checkData(Meeting meeting){

        LocalDateTime start_date = meeting.getStartDate();
        LocalDateTime end_date = meeting.getEndDate();

        if (start_date.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("You cannot insert events into the past");
        }

        if (end_date.isBefore(start_date)) {
            throw new IllegalArgumentException("You mixed up the date");
        }
        return meeting;
    }
}
