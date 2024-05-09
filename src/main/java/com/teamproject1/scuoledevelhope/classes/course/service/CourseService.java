package com.teamproject1.scuoledevelhope.classes.course.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseWithClassesDto;
import com.teamproject1.scuoledevelhope.classes.course.dto.CourseMapper;
import com.teamproject1.scuoledevelhope.classes.course.repo.CourseDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseDAO courseDAO;
    private final CourseMapper courseMapper;
    private final ClassRegisterMapper classRegisterMapper;
    private final ClassDAO classDAO;

    public CourseService(CourseDAO courseDAO, CourseMapper courseMapper, ClassRegisterMapper classRegisterMapper, ClassDAO classDAO) {
        this.courseDAO = courseDAO;
        this.courseMapper = courseMapper;
        this.classRegisterMapper = classRegisterMapper;
        this.classDAO = classDAO;
    }

    public ClassRegisterDtoList findAllClass(Long id, int limit, int page) {
        Page<Classes> classes = classDAO.findAllByCourseId(id, PageRequest.of(page, limit));
        return ClassRegisterDtoList.ClassRegisterDtoListBuilder.aClassRegisterDtoList()
                .withClasses(classRegisterMapper.toListOfClassRegisterDto(classes.toList()))
                .withHttpStatus(HttpStatus.OK)
                .withPage(classes.getPageable().getPageNumber())
                .withPageSize(classes.getPageable().getPageSize())
                .withTotalElements(classes.getTotalElements())
                .withTotalPages(classes.getTotalPages())
                .build();
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

