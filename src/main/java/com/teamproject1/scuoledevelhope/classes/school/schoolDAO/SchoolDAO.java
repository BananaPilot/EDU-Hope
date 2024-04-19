package com.teamproject1.scuoledevelhope.classes.school.schoolDAO;

import com.teamproject1.scuoledevelhope.classes.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchoolDAO extends JpaRepository<School, Long> {
}
