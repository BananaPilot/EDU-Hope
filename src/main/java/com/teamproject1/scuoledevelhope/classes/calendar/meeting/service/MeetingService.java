package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class MeetingService {
    private final MeetingDAO meetingDAO;
    private final MeetingMapper mapper;

    public MeetingService(MeetingDAO meetingDAO, MeetingMapper mapper) {
        this.meetingDAO = meetingDAO;
        this.mapper = mapper;
    }

    //trova meeting by id
   public BaseResponseElement<Meeting> findById(Long id){
        Optional<Meeting> results = meetingDAO.findById(id);
        if (results.isPresent()){
            return new BaseResponseElement<>( results.get());
        }
       throw new SQLException("Student was not present");
   }

    //tutti i meeting di un user
    public BaseResponseList<Meeting> allMeetingByUser(Long id) {
        return new BaseResponseList<>(meetingDAO.allMeetingByUser(id));
    }

    //tutti i meeting di un user in un intervallo di tempo
    public BaseResponseList<Meeting> intervalGetById(Long id, LocalDate startDate, LocalDate endDate) {
        return new BaseResponseList<>(meetingDAO.intervalGetByID(id, startDate, endDate));
    }

    public BaseResponseElement<Meeting> save(Meeting meeting) {
        meeting.setMeetingID(null);
        checkData(meeting);
        return new BaseResponseElement<Meeting>(HttpStatus.CREATED,HttpStatus.CREATED.getReasonPhrase(),"Data saving successful",meetingDAO.save(meeting));
    }

    public BaseResponseElement<MeetingDTO> updateMeeting(MeetingDTO meetingDTO){

        Meeting meeting = meetingDAO.save(mapper.toMeeting(meetingDTO));
        checkData(meeting);
        return new BaseResponseElement<>(HttpStatus.OK,HttpStatus.OK.getReasonPhrase(),"Data updated correctly",mapper.toMeetingDTO(meeting));
    }

    public BaseResponseElement<MeetingDTO> deleteMeeting(Long id){

        MeetingDTO temp = new MeetingDTO();
        temp = mapper.toMeetingDTO(findById(id).getElement());
        meetingDAO.deleteById(id);
        return new BaseResponseElement<>(HttpStatus.OK,HttpStatus.OK.getReasonPhrase(),"Meetings deleted",temp);
    }

    public Meeting checkData(Meeting meeting){

        LocalDateTime start_date = meeting.getStartDate();
        LocalDateTime end_date = meeting.getEndDate();

        if (start_date.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("You cannot insert , update , cancel meeting into the past");
        }

        if (end_date.isBefore(start_date)) {
            throw new IllegalArgumentException("You mixed up the date");
        }
        return meeting;
    }

    public BaseResponseElement<MeetingDTO> cancelMeeting(Long id) {

        Meeting temp = findById(id).getElement();
        temp.setNote("*** This event was canceled on " + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES) + " *** " +temp.getNote());
        temp.setLink("*** Link deleted ***");
        updateMeeting(mapper.toMeetingDTO(temp));

        return  new BaseResponseElement<>(mapper.toMeetingDTO(temp));
    }
}
