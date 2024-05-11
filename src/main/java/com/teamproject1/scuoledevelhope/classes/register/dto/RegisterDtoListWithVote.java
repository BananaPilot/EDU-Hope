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
}
