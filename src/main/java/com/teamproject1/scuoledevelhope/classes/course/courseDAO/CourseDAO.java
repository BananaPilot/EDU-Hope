package com.teamproject1.scuoledevelhope.classes.course.courseDAO;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {
    @Query(value = "select course_name, class_name from class c\n" +
            "join course cr on c.id_course = cr.id_course\n" +
            "where cr.id_course = :idCourse ", nativeQuery = true)
    List<Classes> getClassesByCourse(@Param("idCourse") Long idCourse);

    @Query(value = "select course_name, user_name, user_surname from course c \n" +
            "join class cl on c.id_course = cl.id_course\n" +
            "join tutor t on cl.id_tutor = t.id\n" +
            "join user u on t.id_user = u.id\n" +
            "join user_registry ur on u.user_registry_id = ur.id\n" +
            "where c.id_course = :idCourse", nativeQuery = true)
    List<Tutor> getTutorsByCourse(@Param("idCourse") Long idCourse);

    @Query(value = "select course_name, user_name, user_surname from course c \n" +
            "join class cl on c.id_course = cl.id_course\n" +
            "join student s on cl.id_class = s.id_class\n" +
            "join user u on s.id_user = u.id\n" +
            "join user_registry ur on u.user_registry_id = ur.id\n" +
            "where c.id_course = :idCourse", nativeQuery = true)
    List<Student> getStudentsByCourse(@Param("idCourse") Long idCourse);


}