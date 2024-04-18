package com.teamproject1.scuoledevelhope.classes.student.dao;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentDAO extends JpaRepository<Student, UUID> {
}
