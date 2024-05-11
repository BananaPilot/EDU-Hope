package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;

import java.util.List;

public class RegisterDtoWithVote {
    private RegisterDto registerDto;
    private List<VoteDto> votes;

    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
        this.votes = votes;

    }

    public RegisterDto getRegisterDto() {
        return registerDto;
    }

    public void setRegisterDto(RegisterDto registerDto) {
        this.registerDto = registerDto;
    }


    public static final class RegisterDtoWithVoteBuilder {
        private RegisterDto registerDto;
        private List<VoteDto> votes;

        private RegisterDtoWithVoteBuilder() {
        }

        public static RegisterDtoWithVoteBuilder aRegisterDtoWithVote() {
            return new RegisterDtoWithVoteBuilder();
        }

        public RegisterDtoWithVoteBuilder withRegisterDto(RegisterDto registerDto) {
            this.registerDto = registerDto;
            return this;
        }

        public RegisterDtoWithVoteBuilder withVotes(List<VoteDto> votes) {
            this.votes = votes;
            return this;
        }

        public RegisterDtoWithVote build() {
            RegisterDtoWithVote registerDtoWithVote = new RegisterDtoWithVote();
            registerDtoWithVote.setRegisterDto(registerDto);
            registerDtoWithVote.setVotes(votes);
            return registerDtoWithVote;
        }
    }
}

