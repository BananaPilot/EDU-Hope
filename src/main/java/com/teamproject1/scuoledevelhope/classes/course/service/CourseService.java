package com.teamproject1.scuoledevelhope.classes.course.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseMapper;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseWithClassesDto;
import com.teamproject1.scuoledevelhope.classes.course.repo.CourseDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseDAO courseDAO;
    private final CourseMapper courseMapper;
    private final ClassRegisterMapper classRegisterMapper;
    private final ClassDAO classDAO;
    private final Utils utils;

    public CourseService(CourseDAO courseDAO, CourseMapper courseMapper, ClassRegisterMapper classRegisterMapper, ClassDAO classDAO, Utils utils) {
        this.courseDAO = courseDAO;
        this.courseMapper = courseMapper;
        this.classRegisterMapper = classRegisterMapper;
        this.classDAO = classDAO;
        this.utils = utils;
    }

    public CourseWithClassesDto findAllClass(Long id, int limit, int page) {
        Course course = utils.isPresent(courseDAO.findById(id));
        Page<Classes> classes = classDAO.findAllByCourseId(id, PageRequest.of(page, limit));
        return CourseWithClassesDto.CourseWithClassesDtoBuilder.aCourseWithClassesDto()
                .withClasses(classRegisterMapper.toListOfClassRegisterDto(classes.toList()))
                .withHttpStatus(HttpStatus.OK)
                .withName(course.getName())
                .withSchoolId(course.getSchool().getId())
                .withCourseDescription(course.getDescription())
                .withPage(classes.getPageable().getPageNumber())
                .withPageSize(classes.getPageable().getPageSize())
                .withTotalElements(classes.getTotalElements())
                .withTotalPages(classes.getTotalPages())
                .build();
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

