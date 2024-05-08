package com.teamproject1.scuoledevelhope.classes.classP.repo;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDAO extends JpaRepository<Classes, Long> {

    @Query(value = "select * from class where class_name = :className", nativeQuery = true)
    Classes getByName(@Param("className") String className);

    @Transactional
    @Modifying
    @Query(value = "update class c set id_coordinator = :coordinatorId where id_class = :id", nativeQuery = true)
    void updateClassCoordinator(@Param("id") Long classId, @Param("coordinatorId") Long coordinatorId);

    @Transactional
    @Modifying
    @Query(value = "update class c set id_tutor = :tutorId where id_class = :id", nativeQuery = true)
    void updateClassTutor(@Param("id") Long classId, @Param("tutorId") Long tutorId);
}
