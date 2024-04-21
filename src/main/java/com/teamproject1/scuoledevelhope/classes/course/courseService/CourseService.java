package com.teamproject1.scuoledevelhope.classes.course.courseService;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.courseDAO.CourseDAO;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public BaseResponseList<Course> findAll() {
        return new BaseResponseList<>(courseDAO.findAll());
    }

    public BaseResponseElement<Course> findById(Long id) {
        Optional<Course> result = courseDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Course> save(Course course) {
        return new BaseResponseElement<>(courseDAO.save(course));
    }

    public BaseResponseElement<Course> deleteById(Long id) {
        Optional<Course> temp = courseDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        courseDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }

    public BaseResponseList<Classes> getClassesByCourse(Long id) {
        Optional<Course> result = courseDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        return new BaseResponseList<>(courseDAO.getClassesByCourse(id));
    }

    public BaseResponseList<Tutor> getTutorsByCourse(Long id) {
        Optional<Course> result = courseDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        return new BaseResponseList<>(courseDAO.getTutorsByCourse(id));
    }

    public BaseResponseList<Student> getStudentsByCourse(Long id) {
        Optional<Course> result = courseDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        return new BaseResponseList<>(courseDAO.getStudentsByCourse(id));
    }

}

