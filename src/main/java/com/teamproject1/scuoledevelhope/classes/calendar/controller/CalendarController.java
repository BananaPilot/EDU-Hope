package com.teamproject1.scuoledevelhope.classes.calendar.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.calendar.Calendar;
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
    @FloorLevelAuthorization(floorRole = "USER")
    @GetMapping("/")
    public Calendar intervalGetByJwt(@RequestHeader("Authorization") String jwt, @RequestParam LocalDate startDate, LocalDate endDate, int page, int pageSize) {
        return calendarService.allCalendar(jwt, startDate, endDate, page, pageSize);
    }

    //----------- MEETING ---------//
    //tutti i meeting di un user
    //@FloorLevelAuthorization(floorRole = "COORDINATOR")
    @NoAuthorization
    @GetMapping("/meeting/allMeetingByUserId/{id}")
    public BaseResponseList<MeetingDTO> allMeetingByUser(@PathVariable Long id,@RequestParam int page, int pageSize) {
        return meetingService.allMeetingByUser(id, page, pageSize);
    }

    //tutti i meeting di un user in un intervallo di tempo
    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/meeting/intervalByUserId/{id}")
    public BaseResponseList<MeetingDTO> intervalGetById(@PathVariable Long id, @RequestParam LocalDate startDate, LocalDate endDate) {
        return meetingService.intervalGetById(id, startDate, endDate);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/meeting/save")
    public BaseResponseElement<MeetingDTO> saveMeeting(@RequestBody MeetingDTO meetingDTO) {
        return meetingService.save(meetingDTO);
    }

    //aggiorna il meeting attraverso l id
    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PutMapping("/meeting/update")
    public BaseResponseElement<MeetingDTO> updateMeeting(@RequestBody MeetingDTO meeting) {
        return meetingService.updateMeeting(meeting);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @GetMapping("/meeting/nextByUserId/{id}")
    public BaseResponseElement<MeetingDTO> nextMeetingById(@PathVariable Long id) {
        return meetingService.nextMeetingById(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/meeting/delete/{id}")
    public BaseResponseElement<MeetingDTO> deleteMeeting(@PathVariable Long id) {
        return meetingService.deleteMeeting(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PutMapping("/meeting/cancel/{id}")
    public BaseResponseElement<MeetingDTO> cancelMeeting(@PathVariable Long id) {
        return meetingService.cancelMeeting(id);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @PostMapping("/meeting/addParticipants")
    public BaseResponseElement<MeetingResponse> addParticipants(@RequestBody UserMeetingDTO usDTO) {
        System.out.println(usDTO);
        return meetingService.addParticipants(usDTO);
    }

    @FloorLevelAuthorization(floorRole = "COORDINATOR")
    @DeleteMapping("/meeting/deleteUser")
    public BaseResponseElement<MeetingResponse> removeUserFromMeeting(@RequestBody UserMeetingDTO usDTO) {
        System.out.println(usDTO);

        return meetingService.removeUserFromMeeting(usDTO);
    }
    //-----------END MEETING ---------//
}
