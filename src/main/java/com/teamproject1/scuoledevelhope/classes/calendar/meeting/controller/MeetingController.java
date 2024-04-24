package com.teamproject1.scuoledevelhope.classes.calendar.meeting.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.service.MeetingService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @NoAuthorization
    @GetMapping("/all/{id}")
    public BaseResponseList<Meeting> getAllById(@PathVariable Long id) {
        return meetingService.getAllById(id);
    }

    @NoAuthorization
    @GetMapping("/interval/{id}")
    public BaseResponseList<Meeting> getWithInterval(@PathVariable Long id, @RequestParam LocalDate startDate, LocalDate endDate) {
        return meetingService.intervalGetById(id, startDate, endDate);
    }

    @NoAuthorization
    @PostMapping("/save")
    public BaseResponseElement<Meeting> saveMeeting(@RequestBody Meeting meeting) {
        return meetingService.save(meeting);
    }
}
