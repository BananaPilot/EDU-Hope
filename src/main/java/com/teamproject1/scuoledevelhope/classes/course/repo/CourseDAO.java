package com.teamproject1.scuoledevelhope.classes.course.repo;

import com.teamproject1.scuoledevelhope.classes.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {

}