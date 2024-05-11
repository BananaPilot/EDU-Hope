package com.teamproject1.scuoledevelhope.classes.report.dto;

import com.teamproject1.scuoledevelhope.classes.report.Report;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportMapper() {
    }

    public Report toReport(ReportDto reportDto) {
        return Report.ReportBuilder.aReport()
                .withGradePointAverage(reportDto.getGradePointAverage())
                .withConduct(reportDto.getConduct())
                .build();
    }

    public ReportVoteDto voteDtoToReportVoteDto(VoteDto voteDto){
        return ReportVoteDto.ReportVoteDtoBuilder.aReportVoteDto()
                .withIdStudent(voteDto.getIdStudent())
                .withSubject(voteDto.getSubject())
                .build();
    }

}
