package com.teamproject1.scuoledevelhope.classes.register.registerDAO;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterDao extends JpaRepository<Register, Long> {
    @Query(value = "select * from register where schoolYear = :schoolYear", nativeQuery = true)
    List<Register> getAllBySchoolYear(@Param("schoolYear") String schoolYear);

    @Query(value = "select * from register where tutor = :tutorId", nativeQuery = true)
    List<Register> getAllByTutor(@Param("tutorId") Long tutorId);

    @Modifying
    @Transactional
    @Query(value = "insert into register (school_year, id_school_class, id_tutor) values (:school_year, :id_school_class, :id_tutor)", nativeQuery = true)
    int addRegister(@Param("school_year") String schoolYear, @Param("id_school_class") Long classes, @Param("id_tutor") Long idTutor);

    @Query(value = "select user_name from register r \n" +
            "join student s on r.id_register = s.id_register\n" +
            "join user u on s.id_user = u.id\n" +
            "join user_registry ur on u.user_registry_id = ur.id\n" +
            "where r.id_register = idRegister", nativeQuery = true)
    List<Student> getStudentsByRegister(@Param("idRegister") Long idRegister);

    @Query(value = "select user_name from register r \n" +
            "join tutor t on r.id_tutor = t.id\n" +
            "join user u on t.id_user = u.id\n" +
            "join user_registry ur on u.user_registry_id = ur.id\n" +
            "where r.id_register = idRegister", nativeQuery = true)
    Tutor getTutorByRegister(@Param("idRegister") Long idRegister);

}
