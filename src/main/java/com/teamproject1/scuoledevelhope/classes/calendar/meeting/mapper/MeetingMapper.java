package com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import org.springframework.stereotype.Component;

@Component
public class MeetingMapper {
    MeetingDAO meetingDAO;

    public MeetingMapper(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    public MeetingDTO toMeetingDTO(Meeting meeting) {

        MeetingDTO meetingDTO = new MeetingDTO();

        meetingDTO.setMeetingID(meeting.getMeetingID());
        meetingDTO.setTitle(meeting.getTitle());
        meetingDTO.setStartDate(meeting.getStartDate());
        meetingDTO.setEndDate(meeting.getEndDate());
        meetingDTO.setLink(meeting.getLink());
        meetingDTO.setNote(meeting.getNote());
        return meetingDTO;
    }

    public Meeting toMeeting(MeetingDTO meetingDTO) {

        Meeting meeting = new Meeting();

        meeting.setMeetingID(meetingDTO.getMeetingID());
        meeting.setTitle(meetingDTO.getTitle());
        meeting.setStartDate(meetingDTO.getStartDate());
        meeting.setEndDate(meetingDTO.getEndDate());
        meeting.setLink(meetingDTO.getLink());
        meeting.setNote(meetingDTO.getNote());
        return meeting;
    }
}
