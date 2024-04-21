package com.teamproject1.scuoledevelhope.classes.classP.classDAO;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDAO extends JpaRepository<Classes, Long> {

    //seleziona il tutor di questa classe
    @Query(value = "select class_name, user_name, user_surname from user_registry ur \n" +
            "join user u on ur.id = u.user_registry_id\n" +
            "join tutor t on u.id = t.id_user\n" +
            "join class c on t.id = c.id_tutor\n" +
            "where c.id = :idClass", nativeQuery = true)
    Tutor getTutorByClass(@Param("idClass") Long idClass);

    //seleziona il coordinatore di questa classe
    @Query(value = "select class_name, user_name, user_surname from user_registry ur \n" +
            "join user u on ur.id = u.user_registry_id\n" +
            "join coordinator cr on u.id = cr.id_user\n" +
            "join class c on cr.id_coordinator = c.id_coordinator\n" +
            "where c.id = :idClass", nativeQuery = true)
    Coordinator getCoordinatorByClass(@Param("idClass") Long idClass);

    //seleziona il corso di questa classe
    @Query(value = "select class_name, course_name from class c\n" +
            "join course co on c.id_course = co.id_course\n" +
            "where c.id = :idClass", nativeQuery = true)
    Course getCourseByClass(@Param("idClass") Long idClass);

    //eseleziona tutti gli studenti di questa classe
    @Query(value = "select class_name, user_name, user_surname  from user_registry ur\n" +
            "join user u on ur.id = u.user_registry_id\n" +
            "join student s on u.id = s.id_user\n" +
            "join class c on s.id_class = c.id_class\n" +
            "where c.id = :idClass", nativeQuery = true)
    List<Student> getStudentsByClass(@Param("idClass") Long idClass);

}
