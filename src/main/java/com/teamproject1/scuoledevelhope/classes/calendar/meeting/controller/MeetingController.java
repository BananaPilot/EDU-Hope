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

                                    //----------- STUDENTE----------//
    @NoAuthorization
    @GetMapping("/allByStudentId/{id}")
    public BaseResponseList<Meeting> allByStudentId(@PathVariable Long id) {
        return meetingService.allByStudentId(id);
    }
    @NoAuthorization
    @GetMapping("/intervalStudentId/{id}")
    public BaseResponseList<Meeting> intervalStudentId(@PathVariable Long id , @RequestParam LocalDate startDate , LocalDate endDate){
        return meetingService.intervalStudentId(id,startDate,endDate);
    }

                                    //----------- END STUDENTE----------//



                                    //----------- TUTOR ----------//
    @NoAuthorization
    @GetMapping("/allByTutorId/{id}")
    public BaseResponseList<Meeting> allByTutorId(@PathVariable Long id) {

        return meetingService.allByTutorId(id);
    }

    @NoAuthorization
    @GetMapping("/intervalTutorId/{id}")
    public BaseResponseList<Meeting> intervalTutorId(@PathVariable Long id,@RequestParam LocalDate startDate, LocalDate endDate){

        return meetingService.intervalTutorId(id,startDate,endDate);

    }
                                //----------- END TUTOR ----------//

                                //----------- COORDINATOR ----------//
    @NoAuthorization
    @GetMapping("/allByCoordinatorId/{id}")
    public BaseResponseList<Meeting> allByCoordinatorId(@PathVariable Long id) {
        return meetingService.allByCoordinatorId(id);
    }

    @NoAuthorization
    @GetMapping("/intervalCoordinatorId/{id}")
    public BaseResponseList<Meeting> intervalCoordinatorId(@PathVariable Long id ,@RequestParam LocalDate startDate, LocalDate endDate){
        return meetingService.intervalCoordinatorId(id, startDate, endDate);
    }
                                //----------- END COORDINATOR ----------//
    @NoAuthorization
    @PostMapping("/save")
    public BaseResponseElement<Meeting> saveMeeting(@RequestBody Meeting meeting) {
        return meetingService.save(meeting);
    }


}
