package com.teamproject1.scuoledevelhope.classes.course.courseDAO;

import com.teamproject1.scuoledevelhope.classes.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseDAO extends JpaRepository<Course, UUID> {
}