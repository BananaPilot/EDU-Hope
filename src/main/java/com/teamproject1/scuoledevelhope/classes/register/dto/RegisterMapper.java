package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterMapper {
    private final VoteMapper voteMapper;

    public RegisterMapper(VoteMapper voteMapper) {
        this.voteMapper = voteMapper;
    }

    public RegisterDto toRegisterDto(Register register) {
        return RegisterDto.RegisterDtoBuilder.aRegisterDto()
                .withSchoolYear(register.getSchoolYear())
                .withTutorId(register.getTutor() != null ? register.getTutor().getUser().getId() : null)
                .withNameClass(register.getSchoolClass().getName())
                .build();
    }

    public List<RegisterDto> toRegisterDtoList(List<Register> registers) {
        List<RegisterDto> registerDtoList = new ArrayList<>();
        for (Register element : registers) {
            registerDtoList.add(this.toRegisterDto(element));
        }
        return registerDtoList;
    }

    public RegisterDtoWithVote toRegisterDtoWithVote(Register register) {

        return RegisterDtoWithVote.RegisterDtoWithVoteBuilder.aRegisterDtoWithVote()
                .withRegisterDto(this.toRegisterDto(register))
                .withVotes(voteMapper.toListVoteDto(register.getVotes()))
                .build();
    }

}
