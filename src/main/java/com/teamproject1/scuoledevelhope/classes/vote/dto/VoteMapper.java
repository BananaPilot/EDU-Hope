package com.teamproject1.scuoledevelhope.classes.vote.dto;

import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteMapper {

    private final RegisterDao registerDao;
    private final StudentDAO studentDao;

    public VoteMapper(RegisterDao registerDao, StudentDAO studentDao) {
        this.registerDao = registerDao;
        this.studentDao = studentDao;
    }

    public Vote toVote(VoteDTO voteDto){
        Vote vote = new Vote();

        vote.setAnnotation(voteDto.getAnnotation());
        vote.setDate(voteDto.getDate());
        vote.setEvaluation(voteDto.getEvaluation());
        vote.setRegister(registerDao.getReferenceById(voteDto.getIdRegister()));
        vote.setStudent(studentDao.getReferenceById(voteDto.getIdStudent()));
        //vote.setCheckPoint(voteDto.getCheckPoint());
        if(voteDto.getCheckPoint() == 1){
            vote.setCheckPoint(true);
        }
        if(voteDto.getCheckPoint() == 0){
            vote.setCheckPoint(false);
        }
        vote.setSubject(voteDto.getSubject());

        return vote;
    }

    public VoteDTO toVoteDto(Vote vote){
        VoteDTO voteDto = new VoteDTO();

        voteDto.setAnnotation(vote.getAnnotation());
        voteDto.setDate(vote.getDate());
        voteDto.setEvaluation(vote.getEvaluation());
        voteDto.setIdRegister(vote.getRegister().getId());
        voteDto.setIdStudent(vote.getStudent().getId());
        //voteDto.setCheckPoint(vote.getCheckPoint());
        if(vote.getCheckPoint().equals(true)){
            voteDto.setCheckPoint(1);
        }
        if(vote.getCheckPoint().equals(false)){
            voteDto.setCheckPoint(0);
        }
        voteDto.setSubject(vote.getSubject());

        return voteDto;
    }
}
