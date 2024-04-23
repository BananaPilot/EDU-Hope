package com.teamproject1.scuoledevelhope.classes.calendar.service;

import com.teamproject1.scuoledevelhope.classes.calendar.Calendar;
import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.classes.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.mappers.MeetingMapper;
import com.teamproject1.scuoledevelhope.types.mappers.UserRegistryMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarService {

    MeetingDAO meetingDAO;
    MeetingMapper meetingMapper;
    UserRegistryMapper urMapper;

    UserRegistryDAO urDAO;

    public CalendarService(MeetingDAO meetingDAO, MeetingMapper meetingMapper, UserRegistryMapper urMapper, UserRegistryDAO urDAO) {
        this.meetingDAO = meetingDAO;
        this.meetingMapper = meetingMapper;
        this.urMapper = urMapper;
        this.urDAO = urDAO;
    }

    public BaseResponseElement<Calendar> allCalendar(Long idStudent, LocalDate startDate, LocalDate endDate) {
        List<Meeting> allMeetings = meetingDAO.getMeetingsInInterval(idStudent, startDate, endDate);
        return new BaseResponseElement<>(buildCalendar(startDate, endDate, allMeetings));
    }



    private Calendar buildCalendar(LocalDate startDate, LocalDate endDate, List<Meeting> allMeetings) {

        Calendar calendar = new Calendar();
        calendar.setStartDate(startDate);
        calendar.setEndDate(endDate);

        for (Meeting allMeet : allMeetings) {

            MeetingResponse meetingResponse = new MeetingResponse();
            meetingResponse.setMeetingDTO(meetingMapper.toMeetingDTO(allMeet));

            List<UserRegistry> ur = urDAO.allStudentsByMeeting(allMeet.getMeetingID());
            for (UserRegistry urList : ur) {
                meetingResponse.getParticipants().add(urMapper.toUserRegistryDTO(urList));
            }


            calendar.getCalendar().add(meetingResponse);
        }
        return calendar;
    }

}
