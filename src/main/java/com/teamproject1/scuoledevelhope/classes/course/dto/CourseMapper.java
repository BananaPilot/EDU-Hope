package com.teamproject1.scuoledevelhope.classes.course.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.school.repo.SchoolDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CourseMapper {
    private final SchoolDAO schoolDAO;
    private final ClassRegisterMapper classRegisterMapper;

    public CourseMapper(SchoolDAO schoolDAO, ClassRegisterMapper classRegisterMapper) {
        this.schoolDAO = schoolDAO;
        this.classRegisterMapper = classRegisterMapper;
    }

    public Course courseWithClassesDtotoCourse(CourseWithClassesDto courseDto){
        return Course.CourseBuilder.aCourse()
                .withName(courseDto.getName())
                .withDescription(courseDto.getCourseDescription())
                .withSchool(schoolDAO.findById(courseDto.getSchoolId()).orElse(null))
                .withClasses(classRegisterMapper.toListOfClass(courseDto.getClasses()))
                .build();
    }

    public Course courseDtotoCourse(CourseDto courseDto){
        return Course.CourseBuilder.aCourse()
                .withName(courseDto.getName())
                .withDescription(courseDto.getDescription())
                .withSchool(schoolDAO.findById(courseDto.getSchoolId()).orElse(null))
                .build();
    }

    public CourseDto toCourseDto(Course course){
        return CourseDto.CourseDtoBuilder.aCourseDto()
                .withName(course.getName())
                .withDescription(course.getDescription())
                .withSchoolId(course.getSchool().getId())
                .build();
    }

    public CourseWithClassesDto toCourseWithClassesDto(Course course){
        return CourseWithClassesDto.CourseWithClassesDtoBuilder.aCourseWithClassesDto()
                .withName(course.getName())
                .withDescription(course.getDescription())
                .withSchoolId(course.getSchool().getId())
                .withClasses(classRegisterMapper.toListOfClassRegisterDto(course.getClasses()))
                .build();
    }

    public List<CourseWithClassesDto> toCourseListDto(List<Course> courses){
        List<CourseWithClassesDto> courseListDto = new ArrayList<>();
        for(Course element : courses){
            courseListDto.add(this.toCourseWithClassesDto(element));
        }
        return courseListDto;
    }
}
