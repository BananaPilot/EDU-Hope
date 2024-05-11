package com.teamproject1.scuoledevelhope.classes.report.dto;

public class ReportVoteDto {
    private String subject;
    private Long idStudent;
    private Float conduct;

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

    public Float getConduct() {
        return conduct;
    }

    public void setConduct(Float conduct) {
        this.conduct = conduct;
    }


    public static final class ReportVoteDtoBuilder {
        private String subject;
        private Long idStudent;
        private Float conduct;

        private ReportVoteDtoBuilder() {
        }

        public static ReportVoteDtoBuilder aReportVoteDto() {
            return new ReportVoteDtoBuilder();
        }

        public ReportVoteDtoBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public ReportVoteDtoBuilder withIdStudent(Long idStudent) {
            this.idStudent = idStudent;
            return this;
        }

        public ReportVoteDtoBuilder withConduct(Float conduct) {
            this.conduct = conduct;
            return this;
        }

        public ReportVoteDto build() {
            ReportVoteDto reportVoteDto = new ReportVoteDto();
            reportVoteDto.setSubject(subject);
            reportVoteDto.setIdStudent(idStudent);
            reportVoteDto.setConduct(conduct);
            return reportVoteDto;
        }
    }
}
