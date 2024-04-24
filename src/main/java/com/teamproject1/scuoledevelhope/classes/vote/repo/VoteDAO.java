package com.teamproject1.scuoledevelhope.classes.vote.repo;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into vote(vote_date, vote_evaluation, id_register, id_student, annotation, vote_subject, is_check_point) values (:date, :evaluation, :idRegistry, :idStudent, :annotation, :subject, :isCheckPoint)", nativeQuery = true)
    Vote add(@Param("date") LocalDate date, @Param("evaluation") Float evaluation, @Param("idRegistry") Long registry, @Param("idStudent") Long student, @Param("annotation") String annotation, @Param("subject") String subject, @Param("isCheckPoint") Boolean isCheckPoint);

}
