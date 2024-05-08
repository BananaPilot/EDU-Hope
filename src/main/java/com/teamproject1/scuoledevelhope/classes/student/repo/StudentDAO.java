package com.teamproject1.scuoledevelhope.classes.student.repo;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Long> {
    Page<Student> findAllByRegisterId(Long id, Pageable pageable);
}
