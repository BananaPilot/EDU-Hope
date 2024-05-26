package com.teamproject1.scuoledevelhope.classes.clazz.repo;

import com.teamproject1.scuoledevelhope.classes.clazz.Clazz;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDAO extends JpaRepository<Clazz, Long> {

    @Query(value = "select * from class where class_name = :className", nativeQuery = true)
    Clazz getByName(@Param("className") String className);

    Page<Clazz> findAllByCourseId(Long id, Pageable of);

    @Transactional
    @Modifying
    @Query(value = "update class c set id_coordinator = :coordinatorId where id_class = :id", nativeQuery = true)
    void updateClassCoordinator(@Param("id") Long classId, @Param("coordinatorId") Long coordinatorId);

    @Transactional
    @Modifying
    @Query(value = "update class c set id_tutor = :tutorId where id_class = :id", nativeQuery = true)
    void updateClassTutor(@Param("id") Long classId, @Param("tutorId") Long tutorId);
}
