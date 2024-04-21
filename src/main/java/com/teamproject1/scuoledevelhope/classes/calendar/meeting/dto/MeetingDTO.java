package com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto;

import com.teamproject1.scuoledevelhope.classes.userRegistry.dto.UrDtoNameSurname;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MeetingDTO {
    private String titolo;
    private LocalDate startDate;
    private LocalDate endDate;
    private String tutor;
    private String coordinator;
    private List<UrDtoNameSurname> studentlist;
}
