package com.teamproject1.scuoledevelhope.classes.userRegistry.repo;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistryDAO extends JpaRepository<UserRegistry, Long> {

    // VISUALIZZA TUTTI GLI STUDENTI CHE PARTECIPANO AD UN MEETING
    @Query(value = "select user_registry.*  from user_registry \n" +
            "join user on user_registry .id = user.user_registry_id \n" +
            "join student on user.id = student.id_user \n" +
            "join meeting_student  on meeting_student.id_student_fk = student.id_student \n" +
            "join meeting  on meeting_student.id_meeting_fk = meeting.id_meeting \n" +
            "where id_meeting = :id", nativeQuery = true)
    List<UserRegistry> allStudentsByMeeting(@Param("id") Long id);
}
