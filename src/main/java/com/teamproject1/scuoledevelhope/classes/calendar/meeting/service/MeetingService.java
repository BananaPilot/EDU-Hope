package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MeetingService {

    MeetingDAO meetingDAO;

    public MeetingService(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    public BaseResponseList<Meeting> allByStudentId(Long id){
        return new BaseResponseList<>(meetingDAO.allByStudentId(id));
    }

    public BaseResponseList<Meeting> allByCoordinatorId(Long id){
        return new BaseResponseList<>(meetingDAO.allByCoordinatorId(id));
    }
    public BaseResponseList<Meeting> allByTutorId(Long id){
        return new BaseResponseList<>(meetingDAO.allByTutorId(id));
    }

    public BaseResponseElement<Meeting> save (Meeting meeting){
        return new BaseResponseElement<Meeting> (meetingDAO.save(meeting));
    }

}
