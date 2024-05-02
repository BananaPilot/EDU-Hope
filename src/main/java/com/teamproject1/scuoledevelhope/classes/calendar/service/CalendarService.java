package com.teamproject1.scuoledevelhope.classes.calendar.service;

import com.teamproject1.scuoledevelhope.classes.calendar.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.mapper.UserRegistryMapper;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarService {

    MeetingDAO meetingDAO;
    MeetingMapper meetingMapper;
    UserRegistryMapper urMapper;
    UserRegistryDAO urDAO;
    private final Utils utils;

    public CalendarService(MeetingDAO meetingDAO, MeetingMapper meetingMapper, UserRegistryMapper urMapper, UserRegistryDAO urDAO, Utils utils) {
        this.meetingDAO = meetingDAO;
        this.meetingMapper = meetingMapper;
        this.urMapper = urMapper;
        this.urDAO = urDAO;
        this.utils = utils;
    }

    public Calendar allCalendar(String jwt, LocalDate startDate, LocalDate endDate, int page , int pageSize) {

        Page<Meeting> allMeetings = meetingDAO.intervalGetByIDpageable(utils.getUserFromJwt(jwt).getId(), startDate, endDate, PageRequest.of(page,pageSize));

        Calendar calendar = new Calendar();
        calendar.setStartDate(startDate);
        calendar.setEndDate(endDate);


        for (Meeting allMeet : allMeetings) {

            MeetingResponse meetingResponse = new MeetingResponse();
            meetingResponse.setMeetingDTO(meetingMapper.toMeetingDTO(allMeet));

            List<UserRegistry> ur = urDAO.allUserByMeeting(allMeet.getMeetingID());
            for (UserRegistry urList : ur) {
                meetingResponse.getParticipants().add(urMapper.toUserRegistryDTO(urList));
            }
            calendar.getCalendar().add(meetingResponse);
        }

        calendar.setPage(allMeetings.getPageable().getPageNumber());
        calendar.setTotalPages(allMeetings.getTotalPages());
        calendar.setPageSize(allMeetings.getPageable().getPageSize());
        calendar.setTotalElements(allMeetings.getTotalElements());

        return calendar;

    }
}
