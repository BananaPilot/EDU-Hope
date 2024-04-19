package com.teamproject1.scuoledevelhope.classes.vote.voteDAO;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Long> {
}
