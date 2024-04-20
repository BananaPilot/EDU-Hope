package com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingDAO extends JpaRepository<Meeting, Long> {

    //TUTTI I MEETING DI UN SINGOLO STUDENTE
    @Query(value = "select * from meeting m \n" +
            "join meeting_student ms on ms.id_meeting_fk = m.id_meeting \n" +
            "where ms.id_student_fk  = :idStudent ", nativeQuery = true)
    List<Meeting> allByStudentId(@Param("idStudent") Long idStudent);

    //TUTTI I MEETING DI UN SINGOLO COORDINATORE
    @Query(value = "select * from meeting m where coordinator_id_fk = :idCoordinator", nativeQuery = true)
    List<Meeting> allByCoordinatorId(@Param("idCoordinator") Long idCoordinator);

    //TUTTI I MEETING DI UN SINGOLO TUTOR
    @Query(value = "select * from meeting m where tutor_id_fk = :idTutor", nativeQuery = true)
    List<Meeting> allByTutorId(@Param("idTutor") Long idTutor);

    //TUTTI I MEETING DI UN SINGOLO STUDENTE IN UN INTERVALLO DI TEMPO

    // List<Meeting> intervalDate(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);
}
