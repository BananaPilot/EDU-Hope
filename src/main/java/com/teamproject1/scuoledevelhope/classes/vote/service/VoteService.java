package com.teamproject1.scuoledevelhope.classes.vote.service;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDTO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import com.teamproject1.scuoledevelhope.classes.vote.repo.VoteDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    private final VoteDAO voteDAO;
    private final VoteMapper voteMapper;
    private final StudentDAO studentDAO;

    public VoteService(VoteDAO voteDAO, VoteMapper voteMapper, StudentDAO studentDAO) {
        this.voteDAO = voteDAO;
        this.voteMapper = voteMapper;
        this.studentDAO = studentDAO;
    }

    public BaseResponseList<VoteDTO> findAll() {
        List<Vote> votes = voteDAO.findAll();
        List<VoteDTO> voteDTOS = new ArrayList<>();
        for (Vote element : votes) {
            voteDTOS.add(voteMapper.toVoteDto(element));
        }
        return new BaseResponseList<>(voteDTOS);
    }

    public BaseResponseList<VoteDTO> findByStudent(Long idStudent) {
        List<Vote> votes = voteDAO.findAll();
        List<VoteDTO> voteDTOS = new ArrayList<>();

        for (Vote element : votes) {
            if (element.getIdStudent().getId().equals(idStudent)) {
                voteDTOS.add(voteMapper.toVoteDto(element));
            }
        }

        return new BaseResponseList<>(voteDTOS);
    }

    public BaseResponseElement<VoteDTO> deleteVote(Long idStudent, Long idVote) {
        Optional<Vote> voteR = voteDAO.findById(idVote);
        Optional<Student> studentR = studentDAO.findById(idStudent);

        if (voteR.isEmpty()) {
            throw new SQLException("Vote was not present");
        }
        if (studentR.isEmpty()) {
            throw new SQLException("Student was not present");
        }

        VoteDTO voteDTO = voteMapper.toVoteDto(voteR.get());
        voteDAO.deleteVote(idStudent, idVote);

        return new BaseResponseElement<>(voteDTO);
    }

    public BaseResponseElement<VoteDTO> addVote(VoteDTO voteDTO) {
        voteDAO.save(voteMapper.toVote(voteDTO));

        return new BaseResponseElement<>(voteDTO);
    }
}
