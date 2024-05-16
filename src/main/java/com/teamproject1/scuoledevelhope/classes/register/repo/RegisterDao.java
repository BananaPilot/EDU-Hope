package com.teamproject1.scuoledevelhope.classes.register.repo;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDao extends JpaRepository<Register, Long> {

    Page<Register> findAllByTutorId(Long id, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update register r set r.id_tutor = :tutorId where id_class = :id", nativeQuery = true)
    void updateRegisterTutor(@Param("id") Long registerId, @Param("tutorId") Long tutorId);
}
