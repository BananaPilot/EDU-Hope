package com.teamproject1.scuoledevelhope.classes.meeting.mapper;

import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.meeting.dto.MeetingDTO;
import org.springframework.stereotype.Component;

@Component
public class MeetingMapper {


    MeetingDAO meetingDAO;

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
