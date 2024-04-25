package com.teamproject1.scuoledevelhope.classes.calendar.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.calendar.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.service.CalendarService;
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
    @GetMapping("/{id}")
    public BaseResponseElement<Calendar> intervalGetByID(@PathVariable Long id, @RequestParam LocalDate startDate, LocalDate endDate) {

        return calendarService.allCalendar(id, startDate, endDate);
    }
}
