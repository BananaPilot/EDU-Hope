package com.teamproject1.scuoledevelhope.classes.report.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.BasicAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.report.dto.ReportDto;
import com.teamproject1.scuoledevelhope.classes.report.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @BasicAuthorization(roles = {"STUDENT"})
    @GetMapping
    public ReportDto findReport(@Valid @RequestParam Long idStudent, String subject, int limit, int page) {
        return reportService.findReport(idStudent, subject, limit, page);
    }

    @BasicAuthorization(roles = {"TUTOR"})
    @PutMapping
    public ReportDto addConduct(@RequestParam Long idStudent, String subject, Float conduct){
        return reportService.addConduct(conduct, idStudent, subject);
    }

}
