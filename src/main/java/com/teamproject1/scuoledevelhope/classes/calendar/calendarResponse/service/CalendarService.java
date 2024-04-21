package com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.service;

import com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {

    MeetingDAO meetingDAO;
    MeetingMapper meetingMapper;

    public CalendarService(MeetingDAO meetingDAO, MeetingMapper meetingMapper) {
        this.meetingDAO = meetingDAO;
        this.meetingMapper = meetingMapper;
    }

    public BaseResponseElement<Calendar> studentCalendar(Long idStudent, LocalDate startDate, LocalDate endDate){
        List<Meeting> allMeetings = meetingDAO.intervalStudentId(idStudent,startDate,endDate);
        return new BaseResponseElement<>(buildCalendar(startDate,endDate,allMeetings));
    }

    public BaseResponseElement<Calendar> coordinatorCalendar(Long idCoordinator, LocalDate startDate, LocalDate endDate){
        List<Meeting> allMeetings = meetingDAO.intervalCoordinatorId(idCoordinator,startDate,endDate);
        return new BaseResponseElement<>(buildCalendar(startDate,endDate,allMeetings));
    }

    public BaseResponseElement<Calendar> tutorCalendar(Long idTutor, LocalDate startDate, LocalDate endDate){
        List<Meeting> allMeetings = meetingDAO.intervalTutorId(idTutor,startDate,endDate);
        return new BaseResponseElement<>(buildCalendar(startDate,endDate,allMeetings));
    }



    public Calendar buildCalendar(LocalDate startDate, LocalDate endDate,List<Meeting> allMeetings ){

        Calendar calendar = new Calendar();
        calendar.setStartDate(startDate);
        calendar.setEndDate(endDate);

        for(Meeting allMeet : allMeetings){
            calendar.getCalendar().add(meetingMapper.toMeetingDTO(allMeet));
        }
        return calendar;
    }

}
