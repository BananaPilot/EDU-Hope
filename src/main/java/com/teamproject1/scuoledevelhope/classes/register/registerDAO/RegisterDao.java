package com.teamproject1.scuoledevelhope.classes.register.registerDAO;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RegisterDao extends JpaRepository<Register, UUID>{
    @Query(value = "select * from register where schoolYear = :schoolYear", nativeQuery = true)
    List<Register> getAllBySchoolYear(@Param("schoolYear") String schoolYear);

    @Query(value = "select * from register where tutor = :tutorId", nativeQuery = true)
    List<Register> getAllByTutor(@Param("tutor") UUID tutorId);

    @Modifying
    @Transactional
    @Query(value = "insert into register (schoolYear, cl, tutor) values (:schoolYear, :cl, :tutor)",nativeQuery = true)
    int addRegister(@Param("schoolYear") String schoolYear, @Param("cl") Classes classes, @Param("tutor") Tutor tutor);

}
