package com.teamproject1.scuoledevelhope.classes.report.dto;

import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteResponseDto;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ReportDto extends Pagination {

    private Float conduct;
    private Float gradePointAverage;
    private Long idStudent;
    private String subject;
    private List<VoteResponseDto> votes;

    public Float getConduct() {
        return conduct;
    }

    public void setConduct(Float conduct) {
        this.conduct = conduct;
    }

    public Float getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(Float gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public List<VoteResponseDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteResponseDto> votes) {
        this.votes = votes;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static final class ReportDtoBuilder {
        private Float conduct;
        private Float gradePointAverage;
        private Long idStudent;
        private String subject;
        private List<VoteResponseDto> votes;
        private HttpStatus httpStatus;
        private String message;
        private String description;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;

        private ReportDtoBuilder() {
        }

        public static ReportDtoBuilder aReportDto() {
            return new ReportDtoBuilder();
        }

        public ReportDtoBuilder withConduct(Float conduct) {
            this.conduct = conduct;
            return this;
        }

        public ReportDtoBuilder withGradePointAverage(Float gradePointAverage) {
            this.gradePointAverage = gradePointAverage;
            return this;
        }

        public ReportDtoBuilder withIdStudent(Long idStudent) {
            this.idStudent = idStudent;
            return this;
        }

        public ReportDtoBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public ReportDtoBuilder withVotes(List<VoteResponseDto> votes) {
            this.votes = votes;
            return this;
        }

        public ReportDtoBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ReportDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ReportDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ReportDtoBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public ReportDtoBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ReportDtoBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public ReportDtoBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public ReportDto build() {
            ReportDto reportDto = new ReportDto();
            reportDto.setConduct(conduct);
            reportDto.setGradePointAverage(gradePointAverage);
            reportDto.setIdStudent(idStudent);
            reportDto.setSubject(subject);
            reportDto.setVotes(votes);
            reportDto.setHttpStatus(httpStatus);
            reportDto.setMessage(message);
            reportDto.setDescription(description);
            reportDto.setPage(page);
            reportDto.setPageSize(pageSize);
            reportDto.setTotalElements(totalElements);
            reportDto.setTotalPages(totalPages);
            return reportDto;
        }
    }
}
