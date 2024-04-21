package com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.service.CalendarService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @NoAuthorization
    @GetMapping("/studentCalendar/{idStudent}")
    public BaseResponseElement<Calendar> studentCalendar(@PathVariable Long idStudent, @RequestParam LocalDate startDate, LocalDate endDate) {

        return calendarService.studentCalendar(idStudent, startDate, endDate);
    }

    @NoAuthorization
    @GetMapping("/coordinatorCalendar/{idCoordinator}")
    public BaseResponseElement<Calendar> coordinatorCalendar(@PathVariable Long idCoordinator, @RequestParam LocalDate startDate, LocalDate endDate) {

        return calendarService.coordinatorCalendar(idCoordinator, startDate, endDate);
    }

    @NoAuthorization
    @GetMapping("/tutorCalendar/{idTutor}")
    public BaseResponseElement<Calendar> tutorCalendar(@PathVariable Long idTutor, @RequestParam LocalDate startDate, LocalDate endDate) {

        return calendarService.tutorCalendar(idTutor, startDate, endDate);
    }
}
