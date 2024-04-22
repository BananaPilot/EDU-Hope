package com.teamproject1.scuoledevelhope.classes.vote.voteService;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.voteDAO.VoteDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {
    private final VoteDAO voteDAO;

    public VoteService(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }

    public BaseResponseList<Vote> findAll() {

        return new BaseResponseList<>(voteDAO.findAll());
    }

    public BaseResponseElement<Vote> findById(Long id) {
        Optional<Vote> result = voteDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Vote was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Vote> save(Vote vote) {
        return new BaseResponseElement<>(voteDAO.save(vote));
    }

    public BaseResponseElement<Vote> deleteById(Long id) {
        Optional<Vote> temp = voteDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Vote was not present");
        }
        voteDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }

    public BaseResponseList<Vote> getVoteByStudent(Long id){
        Optional<Vote> temp = voteDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Register was not present");
        }
        return new BaseResponseList<>(voteDAO.getVoteByStudent(id));
    }
}
