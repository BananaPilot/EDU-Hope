package com.teamproject1.scuoledevelhope.classes.vote.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;

public class VoteDtoList extends Pagination {
    private List<VoteDto> votes;

    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
        this.votes = votes;
    }


    public static final class VoteDtoListBuilder {
        private List<VoteDto> votes;
        private HttpStatus httpStatus;
        private String message;
        private String description;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;

        private VoteDtoListBuilder() {
        }

        public static VoteDtoListBuilder aVoteDtoList() {
            return new VoteDtoListBuilder();
        }

        public VoteDtoListBuilder withVotes(List<VoteDto> votes) {
            this.votes = votes;
            return this;
        }

        public VoteDtoListBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public VoteDtoListBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public VoteDtoListBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public VoteDtoListBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public VoteDtoListBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public VoteDtoListBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public VoteDtoListBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public VoteDtoList build() {
            VoteDtoList voteDtoList = new VoteDtoList();
            voteDtoList.setVotes(votes);
            voteDtoList.setHttpStatus(httpStatus);
            voteDtoList.setMessage(message);
            voteDtoList.setDescription(description);
            voteDtoList.setPage(page);
            voteDtoList.setPageSize(pageSize);
            voteDtoList.setTotalElements(totalElements);
            voteDtoList.setTotalPages(totalPages);
            return voteDtoList;
        }
    }
}
