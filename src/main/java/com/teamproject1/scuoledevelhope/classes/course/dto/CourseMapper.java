package com.teamproject1.scuoledevelhope.classes.course.dto;

import com.teamproject1.scuoledevelhope.classes.clazzez.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.school.repo.SchoolDAO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    private final SchoolDAO schoolDAO;
    private final ClassRegisterMapper classRegisterMapper;

    public CourseMapper(SchoolDAO schoolDAO, ClassRegisterMapper classRegisterMapper) {
        this.schoolDAO = schoolDAO;
        this.classRegisterMapper = classRegisterMapper;
    }

    public Course courseDtotoCourse(CourseDto courseDto) {
        return Course.CourseBuilder.aCourse()
                .withName(courseDto.getName())
                .withDescription(courseDto.getDescription())
                .withSchool(schoolDAO.findById(courseDto.getSchoolId()).orElse(null))
                .build();
    }

    public CourseDto toCourseDto(Course course) {
        return CourseDto.CourseDtoBuilder.aCourseDto()
                .withName(course.getName())
                .withDescription(course.getDescription())
                .withSchoolId(course.getSchool().getId())
                .build();
    }
}
