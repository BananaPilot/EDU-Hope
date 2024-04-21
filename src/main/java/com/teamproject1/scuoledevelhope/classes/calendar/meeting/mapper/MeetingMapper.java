package com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.coordinator.dao.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.DAO.TutorDAO;
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
        meetingDTO.setTutor("sostituisci con nome e cognome tutor");
        meetingDTO.setCoordinator("sostituisci con nome e cognome coordinator");
        meetingDTO.setNote(meeting.getNote());

        return meetingDTO;
    }
}
