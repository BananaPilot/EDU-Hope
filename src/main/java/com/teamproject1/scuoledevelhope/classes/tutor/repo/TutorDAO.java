package com.teamproject1.scuoledevelhope.classes.tutor.repo;

import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorDAO extends JpaRepository<Tutor, Long> {

}
