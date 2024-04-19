package com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.controller;

import com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.Calendar;
import com.teamproject1.scuoledevelhope.classes.calendar.calendarResponse.service.CalendarService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/intervaldate")
    public BaseResponseElement<Calendar> intervalDate(@RequestParam LocalDate startDate, LocalDate endDate){

        return calendarService.intervalDate(startDate,endDate);
    }
}
