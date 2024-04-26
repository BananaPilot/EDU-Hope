package com.teamproject1.scuoledevelhope.classes.vote.repo;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete v from vote v \n" +
            "join student s on v.id_student = s.user_id \n" +
            "where s.user_id  = ?1 AND v.id_vote = ?2", nativeQuery = true)
    void deleteVote(Long idStudent, Long idVote);

}
