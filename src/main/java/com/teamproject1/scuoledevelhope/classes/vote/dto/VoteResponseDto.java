package com.teamproject1.scuoledevelhope.classes.vote.dto;

import java.time.LocalDate;

public class VoteResponseDto {
    private LocalDate date;
    private Float evaluation;
    private String annotation;
    private Boolean isCheckPoint;

    public VoteResponseDto() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Float evaluation) {
        this.evaluation = evaluation;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Boolean getIsCheckPoint() {
        return isCheckPoint;
    }

    public void setIsCheckPoint(Boolean isCheckPoint) {
        this.isCheckPoint = isCheckPoint;
    }


    public static final class VoteResponseDtoBuilder {
        private LocalDate date;
        private Float evaluation;
        private String annotation;
        private Boolean isCheckPoint;

        private VoteResponseDtoBuilder() {
        }

        public static VoteResponseDtoBuilder aVoteResponseDto() {
            return new VoteResponseDtoBuilder();
        }

        public VoteResponseDtoBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public VoteResponseDtoBuilder withEvaluation(Float evaluation) {
            this.evaluation = evaluation;
            return this;
        }

        public VoteResponseDtoBuilder withAnnotation(String annotation) {
            this.annotation = annotation;
            return this;
        }

        public VoteResponseDtoBuilder withIsCheckPoint(Boolean isCheckPoint) {
            this.isCheckPoint = isCheckPoint;
            return this;
        }

        public VoteResponseDto build() {
            VoteResponseDto voteResponseDto = new VoteResponseDto();
            voteResponseDto.setDate(date);
            voteResponseDto.setEvaluation(evaluation);
            voteResponseDto.setAnnotation(annotation);
            voteResponseDto.setIsCheckPoint(isCheckPoint);
            return voteResponseDto;
        }
    }
}
