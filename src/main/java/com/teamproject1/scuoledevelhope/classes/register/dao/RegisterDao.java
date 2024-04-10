package com.teamproject1.scuoledevelhope.classes.register.dao;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegisterDao extends JpaRepository<Register,Integer> {

    @Query(value = "select * from register", nativeQuery = true)
    List<Register> getAll();

    @Query(value = "select * from register where schoolYear = :schoolYear", nativeQuery = true)
    List<Register> getAllBySchoolYear(@Param("schoolYear") LocalDate schoolYear);

    @Query(value = "select * from register where tutor = :tutor", nativeQuery = true)
    List<Register> getAllByTutor(@Param("tutor") Tutor tutor);

    @Modifying
    @Transactional
    @Query(value = "insert into register (schoolYear, cl, tutor ) values (:schoolYear, :cl, :tutor)",nativeQuery = true)
    int addUser(@Param("schoolYear") LocalDate schoolYear, @Param("cl") Classes classes, Tutor tutor);
}
