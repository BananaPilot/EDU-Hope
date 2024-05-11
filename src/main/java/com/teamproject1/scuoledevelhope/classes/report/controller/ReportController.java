package com.teamproject1.scuoledevelhope.classes.report.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.teamproject1.scuoledevelhope.classes.report.dto.ReportDto;
import com.teamproject1.scuoledevelhope.classes.report.dto.ReportVoteDto;
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


    @FloorLevelAuthorization(floorRole = "TUTOR")
    @PostMapping("/save")
    public ReportDto save(@Valid @RequestBody ReportVoteDto reportVoteDto, @RequestParam int limit, int page) {
        return reportService.save(reportVoteDto, limit, page);
    }
}
