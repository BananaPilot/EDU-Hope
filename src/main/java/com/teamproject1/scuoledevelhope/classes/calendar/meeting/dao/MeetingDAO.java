package com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MeetingDAO extends JpaRepository<Meeting, Long> {
    //----------- STUDENT----------//
    //TUTTI I MEETING DI UN SINGOLO STUDENTE
    @Query(value = "select meeting.* from meeting\n" +
            "join meeting_student on meeting.id_meeting = meeting_student.id_meeting_fk \n" +
            "where meeting_student.id_student_fk = :idStudent", nativeQuery = true)
    List<Meeting> allByStudentId(@Param("idStudent") Long idStudent);

    //MEETING DI STUDENTE IN UN INTERVALLO DI TEMPO
    @Query(value = "select meeting.* from meeting\n" +
            "join meeting_student on meeting.id_meeting = meeting_student.id_meeting_fk \n" +
            "where meeting_student.id_student_fk = :idStudent\n" +
            "and meeting.start_date > :startDate and meeting.start_date < :endDate", nativeQuery = true)
    List<Meeting> intervalStudentId(@Param("idStudent") Long idStudent, @Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
   

    //----------- TUTOR ----------//

    //TUTTI I MEETING DI UN SINGOLO TUTOR
    @Query(value = "select * from meeting m where tutor_id_fk = :idTutor", nativeQuery = true)
    List<Meeting> allByTutorId(@Param("idTutor") Long idTutor);

    //TUTTI I MEETING DI UN SINGOLO TUTOR IN UN INTERVALLO DI TEMPO
    @Query(value = "select * from meeting \n" +
            "where tutor_id_fk = :idTutor\n" +
            "and meeting.start_date > :startDate and meeting.start_date < :endDate", nativeQuery = true)
    List<Meeting> intervalTutorId(@Param("idTutor") Long idTutor, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //----------- END TUTOR ----------//
    //----------- COORDINATOR ----------//
    //TUTTI I MEETING DI UN SINGOLO COORDINATORE
    @Query(value = "select * from meeting m where coordinator_id_fk = :idCoordinator", nativeQuery = true)
    List<Meeting> allByCoordinatorId(@Param("idCoordinator") Long idCoordinator);

    //TUTTI I MEETING DI UN SINGOLO COORDINATORE IN UN INTERVALLO DI TEMPO
    @Query(value = "select * from meeting \n" +
            "where coordinator_id_fk = :idCoordinator\n" +
            "and meeting.start_date > :startDate and meeting.start_date < :endDate", nativeQuery = true)
    List<Meeting> intervalCoordinatorId(@Param("idCoordinator") Long idCoordinator, LocalDate startDate, LocalDate endDate);

    //----------- END COORDINATOR ----------//
}
