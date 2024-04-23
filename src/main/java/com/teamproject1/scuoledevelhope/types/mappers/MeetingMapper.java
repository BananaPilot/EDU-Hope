package com.teamproject1.scuoledevelhope.types.mappers;

import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.types.dtos.MeetingDTO;
import org.springframework.stereotype.Component;

@Component
public class MeetingMapper {


    MeetingDAO meetingDAO;
    CoordinatorDAO coordinatorDAO;
    TutorDAO tutorDAO;

    public MeetingMapper(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    public MeetingDTO toMeetingDTO(Meeting meeting) {

        MeetingDTO meetingDTO = new MeetingDTO();

        meetingDTO.setTitolo(meeting.getTitle());
        meetingDTO.setStartDate(meeting.getStartDate());
        meetingDTO.setEndDate(meeting.getEndDate());
        meetingDTO.setNote(meeting.getNote());

        return meetingDTO;
    }
}
