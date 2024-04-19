package com.teamproject1.scuoledevelhope.classes.register.registerDAO;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RegisterDao extends JpaRepository<Register, Long> {
    @Query(value = "select * from register where schoolYear = :schoolYear", nativeQuery = true)
    List<Register> getAllBySchoolYear(@Param("schoolYear") String schoolYear);

    @Query(value = "select * from register where tutor = :tutorId", nativeQuery = true)
    List<Register> getAllByTutor(@Param("tutor") Long tutorId);

    @Modifying
    @Transactional
    @Query(value = "insert into register (school_year, id_school_class, id_tutor) values (:school_year, :id_school_class, :id_tutor)", nativeQuery = true)
    int addRegister(@Param("school_year") String schoolYear, @Param("id_school_class") Long classes, @Param("id_tutor") Long idTutor);

}
