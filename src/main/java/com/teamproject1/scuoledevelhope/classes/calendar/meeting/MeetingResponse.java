package com.teamproject1.scuoledevelhope.classes.calendar.meeting;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.user_registry.dto.UserRegistryDTO;

import java.util.ArrayList;
import java.util.List;

public class MeetingResponse {

    private MeetingDTO meetingDTO;
    private List<UserRegistryDTO> participants = new ArrayList<>();

    public MeetingResponse() {
    }

    public void setMeetingDTO(MeetingDTO meetingDTO) {
        this.meetingDTO = meetingDTO;
    }

    public void setParticipants(List<UserRegistryDTO> participants) {
        this.participants = participants;
    }

    public MeetingDTO getMeetingDTO() {
        return meetingDTO;
    }

    public List<UserRegistryDTO> getParticipants() {
        return participants;
    }
}
