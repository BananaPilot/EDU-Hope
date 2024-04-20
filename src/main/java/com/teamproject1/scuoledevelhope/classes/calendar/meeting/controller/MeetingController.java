package com.teamproject1.scuoledevelhope.classes.calendar.meeting.controller;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.service.MeetingService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/allByStudentId/{id}")
    public BaseResponseList<Meeting> allByStudentId(@PathVariable Long id) {
        return meetingService.allByStudentId(id);
    }

    @GetMapping("/allByCoordinatorId/{id}")
    public BaseResponseList<Meeting> allByCoordinatorId(@PathVariable Long id) {
        return meetingService.allByCoordinatorId(id);
    }

    @GetMapping("/allByTutorId/{id}")
    public BaseResponseList<Meeting> allByTutorId(@PathVariable Long id) {
        return meetingService.allByTutorId(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<Meeting> saveMeeting(@RequestBody Meeting meeting) {
        return meetingService.save(meeting);
    }
}
