package com.teamproject1.scuoledevelhope.classes.vote.repo;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Long> {
    @Query(value = "select v.* from vote v\n" +
            "join student s on v.id_student = s.id_student\n" +
            "where s.id_student = idStudent", nativeQuery = true)
    List<Vote> getVoteByStudent(@Param("idStudent") Long idStudent);
}
