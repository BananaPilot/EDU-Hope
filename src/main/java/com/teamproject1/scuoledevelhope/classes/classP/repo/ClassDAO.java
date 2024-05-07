package com.teamproject1.scuoledevelhope.classes.classP.repo;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDAO extends JpaRepository<Classes, Long> {

    @Query(value = "select * from class where class_name = :className", nativeQuery = true)
    Classes getByName(@Param("className") String className);

}
