package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;

import java.util.List;

public class RegisterDtoListWithVote extends Pagination {

    private List<RegisterDtoWithVote> registerDtoList;

    public RegisterDtoListWithVote(List<RegisterDtoWithVote> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }

    public RegisterDtoListWithVote() {
    }

    public List<RegisterDtoWithVote> getRegisterDtoList() {
        return registerDtoList;
    }

    public void setRegisterDtoList(List<RegisterDtoWithVote> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }


    public static final class RegisterDtoListWithVoteBuilder {
        private List<RegisterDtoWithVote> registerDtoList;

        private RegisterDtoListWithVoteBuilder() {
        }

        public static RegisterDtoListWithVoteBuilder aRegisterDtoListWithVote() {
            return new RegisterDtoListWithVoteBuilder();
        }

        public RegisterDtoListWithVoteBuilder withRegisterDtoList(List<RegisterDtoWithVote> registerDtoList) {
            this.registerDtoList = registerDtoList;
            return this;
        }

        public RegisterDtoListWithVote build() {
            RegisterDtoListWithVote registerDtoListWithVote = new RegisterDtoListWithVote();
            registerDtoListWithVote.setRegisterDtoList(registerDtoList);
            return registerDtoListWithVote;
        }
    }
}
