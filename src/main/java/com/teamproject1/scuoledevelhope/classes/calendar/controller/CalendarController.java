package com.teamproject1.scuoledevelhope.classes.calendar.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.calendar.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.service.MeetingService;
import com.teamproject1.scuoledevelhope.classes.calendar.service.CalendarService;
import com.teamproject1.scuoledevelhope.classes.userMeeting.dto.UserMeetingDTO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    CalendarService calendarService;
    MeetingService meetingService;

    public CalendarController(CalendarService calendarService, MeetingService meetingService) {
        this.calendarService = calendarService;
        this.meetingService = meetingService;
    }

    //calendario di un utente in un intervallo di tempo
    @NoAuthorization
    @GetMapping("/{id}")
    public BaseResponseElement<Calendar> intervalGetByID(@PathVariable Long id, @RequestParam LocalDate startDate, LocalDate endDate) {
        return calendarService.allCalendar(id, startDate, endDate);
    }

    //----------- MEETING ---------//
    //tutti i meeting di un user
    @NoAuthorization
    @GetMapping("/meeting/allMeetingByUserId/{id}")
    public BaseResponseList<Meeting> allMeetingByUser(@PathVariable Long id) {
        return meetingService.allMeetingByUser(id);
    }

    //tutti i meeting di un user in un intervallo di tempo
    @NoAuthorization
    @GetMapping("/meeting/intervalByUserId/{id}")
    public BaseResponseList<Meeting> intervalGetById(@PathVariable Long id, @RequestParam LocalDate startDate, LocalDate endDate) {
        return meetingService.intervalGetById(id, startDate, endDate);
    }

    @NoAuthorization
    @PostMapping("/meeting/save")
    public BaseResponseElement<Meeting> saveMeeting(@RequestBody Meeting meeting) {
        return meetingService.save(meeting);
    }

    //aggiorna il meeting attraverso l id
    @NoAuthorization
    @PutMapping("/meeting/update")
    public BaseResponseElement<MeetingDTO> updateMeeting(@RequestBody MeetingDTO meeting) {
        return meetingService.updateMeeting(meeting);
    }

    @NoAuthorization
    @GetMapping("/meeting/nextByUserId/{id}")
    public BaseResponseElement<MeetingDTO> nextMeetingById(@PathVariable Long id) {
        return meetingService.nextMeetingById(id);
    }

    @NoAuthorization
    @GetMapping("/meeting/delete/{id}")
    public BaseResponseElement<MeetingDTO> deleteMeeting(@PathVariable Long id) {
        return meetingService.deleteMeeting(id);
    }

    @NoAuthorization
    @GetMapping("/meeting/cancel/{id}")
    public BaseResponseElement<MeetingDTO> cancelMeeting(@PathVariable Long id) {
        return meetingService.cancelMeeting(id);
    }

    @NoAuthorization
    @PostMapping("/meeting/addParticipants")
    public BaseResponseElement<MeetingResponse> addParticipants(@RequestBody UserMeetingDTO usDTO) {
        System.out.println(usDTO);
        return meetingService.addParticipants(usDTO);
    }
                        //-----------END MEETING ---------//
}
