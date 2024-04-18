package com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MeetingDAO extends JpaRepository<Meeting,UUID> {

    @Query(value ="select * from meeting m \n" +
            "join meeting_student ms on ms.id_meeting = m.meeting_id \n" +
            "where ms.id_student  = :idStudent ", nativeQuery = true)
    List<Meeting> allByStudentId(@Param("idStudent") UUID idStudent);

    @Query(value = "select * from meeting m where coordinator_id_fk = :idCoordinator", nativeQuery = true)
    List<Meeting> allByCoordinatorId(@Param("idCoordinator") UUID idCoordinator);

    @Query(value = "select * from meeting m where tutor_id_fk = :idTutor", nativeQuery = true)
    List<Meeting> allByTutorId(@Param("idTutor") UUID idTutor);

}
