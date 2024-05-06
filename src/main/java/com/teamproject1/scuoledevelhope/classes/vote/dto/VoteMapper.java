package com.teamproject1.scuoledevelhope.classes.vote.dto;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.internal.bytebuddy.dynamic.DynamicType;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VoteMapper {
    private final ModelMapper modelMapper;
    private final RegisterDao registerDao;
    private final StudentDAO studentDao;

    public VoteMapper(ModelMapper modelMapper, RegisterDao registerDao, StudentDAO studentDAO) {
        this.modelMapper = modelMapper;
        this.registerDao = registerDao;
        this.studentDao = studentDAO;
    }


    public Vote toVote(VoteDTO voteDto) {
        return Vote.VoteBuilder.aVote()
                .withDate(voteDto.getDate())
                .withAnnotation(voteDto.getAnnotation())
                .withEvaluation(voteDto.getEvaluation())
                .withRegister(registerDao.findById(voteDto.getIdRegister()).orElse(null))
                .withStudent(studentDao.findById(voteDto.getIdStudent()).orElse(null))
                .withIsCheckPoint(voteDto.getIsCheckPoint())
                .withSubject(voteDto.getSubject())
                .build();
    }

    public VoteDTO toVoteDto(Vote vote) {
        return VoteDTO.VoteDTOBuilder.aVoteDTO()
                .withDate(vote.getDate())
                .withAnnotation(vote.getAnnotation())
                .withEvaluation(vote.getEvaluation())
                .withIdRegister(vote.getIdRegister().getId())
                .withIdStudent(vote.getIdStudent().getId())
                .withIsCheckPoint(vote.getIsCheckPoint())
                .withSubject(vote.getSubject())
                .build();
    }

    public List<Vote> toVoteList(List<VoteDTO> voteDtoList){
        List<Vote> voteList = new ArrayList<>();
        for(VoteDTO element : voteDtoList){
            voteList.add(this.toVote(element));
        }
        return voteList;
    }

    public List<VoteDTO> toVoteDtoList(List<Vote> votes){
        List<VoteDTO> voteDtoList = new ArrayList<>();
        for(Vote element : votes){
            voteDtoList.add(this.toVoteDto(element));
        }
        return voteDtoList;
    }

}
