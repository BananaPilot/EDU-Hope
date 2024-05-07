package com.teamproject1.scuoledevelhope.classes.course.service;

import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseWithClassesDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseMapper;
import com.teamproject1.scuoledevelhope.classes.course.repo.CourseDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseDAO courseDAO;
    private final CourseMapper courseMapper;

    public CourseService(CourseDAO courseDAO, CourseMapper courseMapper) {
        this.courseDAO = courseDAO;
        this.courseMapper = courseMapper;
    }

    public BaseResponseList<CourseWithClassesDto> findAll() {
        return new BaseResponseList<>(courseMapper.toCourseListDto(courseDAO.findAll()));
    }

    public BaseResponseElement<CourseWithClassesDto> findById(Long id) {
        Optional<Course> result = courseDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        return new BaseResponseElement<>(courseMapper.toCourseWithClassesDto(result.get()));
    }

    public BaseResponseElement<CourseDto> save(CourseDto courseDto) {

        courseDAO.save(courseMapper.courseDtotoCourse(courseDto));
        return new BaseResponseElement<>(courseDto);
    }

    public BaseResponseElement<CourseDto> deleteById(Long id) {
        Optional<Course> temp = courseDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Course was not present");
        }
        courseDAO.deleteById(id);

        return new BaseResponseElement<>(courseMapper.toCourseDto(temp.get()));
    }
}

