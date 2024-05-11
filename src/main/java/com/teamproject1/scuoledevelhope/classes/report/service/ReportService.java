package com.teamproject1.scuoledevelhope.classes.report.service;

import com.teamproject1.scuoledevelhope.classes.report.dto.ReportDto;
import com.teamproject1.scuoledevelhope.classes.report.dto.ReportMapper;
import com.teamproject1.scuoledevelhope.classes.report.dto.ReportVoteDto;
import com.teamproject1.scuoledevelhope.classes.report.repo.ReportDao;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import com.teamproject1.scuoledevelhope.classes.vote.repo.VoteDAO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportDao reportDao;
    private final VoteDAO voteDao;
    private final VoteMapper voteMapper;
    private final ReportMapper reportMapper;

    public ReportService(ReportDao reportDao, VoteDAO voteDao, VoteMapper voteMapper, ReportMapper reportMapper) {
        this.reportDao = reportDao;
        this.voteDao = voteDao;
        this.voteMapper = voteMapper;
        this.reportMapper = reportMapper;
    }

    @Transactional
    public ReportDto save(ReportVoteDto reportVoteDto, int limit, int page) {
        Page<Vote> votes = voteDao.findBySubjectAndStudentId(reportVoteDto.getSubject(), reportVoteDto.getIdStudent(), PageRequest.of(page, limit));

        List<Vote> voteList = voteDao.findBySubjectAndStudentId(reportVoteDto.getSubject(), reportVoteDto.getIdStudent());

        Float gradePointAverage = 0F;

        for (Vote element : voteList) {
            gradePointAverage += element.getEvaluation();
        }
        gradePointAverage /= voteList.size();

        ReportDto response = ReportDto.ReportDtoBuilder.aReportDto()
                .withGradePointAverage(gradePointAverage)
                .withVotes(voteMapper.toListVoteDto(votes.toList()))
                .withConduct(reportVoteDto.getConduct())
                .withPage(votes.getPageable().getPageNumber())
                .withPageSize(votes.getPageable().getPageSize())
                .withTotalElements(votes.getTotalElements())
                .withTotalPages(votes.getTotalPages())
                .build();

        reportDao.save(reportMapper.toReport(response));

        return response;
    }

}
