package com.teamproject1.scuoledevelhope.classes.calendar.service;

import com.teamproject1.scuoledevelhope.classes.calendar.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.classes.userRegistry.mapper.UserRegistryMapper;
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

    public BaseResponseElement<Calendar> allCalendar(Long id, LocalDate startDate, LocalDate endDate) {
      List<Meeting> allMeetings = meetingDAO.intervalGetByID(id, startDate, endDate);
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
