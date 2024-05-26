package com.teamproject1.scuoledevelhope.classes.report.dto;

import com.teamproject1.scuoledevelhope.classes.report.Report;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {
    private final StudentDAO studentDAO;

    public ReportMapper(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Report toReport(ReportDto reportDto) {
        return Report.ReportBuilder.aReport()
                .withGradePointAverage(reportDto.getGradePointAverage())
                .withConduct(reportDto.getConduct())
                .withSubject(reportDto.getSubject())
                .withStudent(studentDAO.findById(reportDto.getIdStudent()).orElse(null))
                .build();
    }


    public ReportVoteDto voteDtoToReportVoteDto(VoteDto voteDto) {
        return ReportVoteDto.ReportVoteDtoBuilder.aReportVoteDto()
                .withIdStudent(voteDto.getIdStudent())
                .withSubject(voteDto.getSubject())
                .build();
    }

    public ReportDto toReportDto(Report report){
        return ReportDto.ReportDtoBuilder.aReportDto()
                .withSubject(report.getSubject())
                .withIdStudent(report.getStudent().getId())
                .withGradePointAverage(report.getGradePointAverage())
                .withConduct(report.getConduct())
                .build();
    }

}
