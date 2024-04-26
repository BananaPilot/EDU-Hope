package com.teamproject1.scuoledevelhope.classes.school.repo;

import com.teamproject1.scuoledevelhope.classes.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDAO extends JpaRepository<School, Long> {
}
