package com.teamproject1.scuoledevelhope.classes.vote.repo;

import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete v from vote v join student s on v.id_student = s.user_id where s.user_id  = ?1 AND v.id_vote = ?2", nativeQuery = true)
    void deleteVote(Long idStudent, Long idVote);

    @Query(value = "select * from vote where vote_subject = :subject and id_student = :idStudent", nativeQuery = true)
    Page<Vote> findBySubjectAndStudentId(@Param("subject") String subject, @Param("idStudent") Long idStudent, Pageable pageable);

    @Query(value = "select * from vote where vote_subject = :subject and id_student = :idStudent", nativeQuery = true)
    List<Vote> findBySubjectAndStudentId(@Param("subject") String subject, @Param("idStudent") Long idStudent);

    Page<Vote> findAllByRegisterId(Long registerId, Pageable pageable);

    Page<Vote> findAllByStudentId(Long idStudent, Pageable pageable);
}