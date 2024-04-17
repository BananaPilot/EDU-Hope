package com.teamproject1.scuoledevelhope.classes.tutor.DAO;

import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TutorDAO extends JpaRepository<Tutor, UUID> {
}
