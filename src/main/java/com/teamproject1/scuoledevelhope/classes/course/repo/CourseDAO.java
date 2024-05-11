package com.teamproject1.scuoledevelhope.classes.course.repo;

import com.teamproject1.scuoledevelhope.classes.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {

}