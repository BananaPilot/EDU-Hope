package com.teamproject1.scuoledevelhope.classes.vote.voteDAO;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Long> {

}
