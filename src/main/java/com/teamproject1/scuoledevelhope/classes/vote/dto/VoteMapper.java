package com.teamproject1.scuoledevelhope.classes.vote.dto;

import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VoteMapper {
    private final RegisterDao registerDao;
    private final StudentDAO studentDao;

    public VoteMapper(RegisterDao registerDao, StudentDAO studentDAO) {
        this.registerDao = registerDao;
        this.studentDao = studentDAO;
    }


    public Vote toVote(VoteDto voteDto) {
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

    public VoteDto toVoteDto(Vote vote) {
        return VoteDto.VoteDTOBuilder.aVoteDTO()
                .withDate(vote.getDate())
                .withAnnotation(vote.getAnnotation())
                .withEvaluation(vote.getEvaluation())
                .withIdRegister(vote.getIdRegister().getId())
                .withIdStudent(vote.getIdStudent() != null ? vote.getIdStudent().getId() : null)
                .withIsCheckPoint(vote.getIsCheckPoint())
                .withSubject(vote.getSubject())
                .build();
    }

    public List<Vote> toVoteList(List<VoteDto> voteDtoList) {
        List<Vote> voteList = new ArrayList<>();
        for (VoteDto element : voteDtoList) {
            voteList.add(this.toVote(element));
        }
        return voteList;
    }

    public List<VoteDto> toListVoteDto(List<Vote> votes) {
        List<VoteDto> voteDtoList = new ArrayList<>();
        for (Vote element : votes) {
            voteDtoList.add(this.toVoteDto(element));
        }
        return voteDtoList;
    }

    public VoteDtoList toVoteDtoList(List<Vote> votes) {
        return VoteDtoList.VoteDtoListBuilder.aVoteDtoList()
                .withVotes(this.toListVoteDto(votes))
                .build();
    }

}
