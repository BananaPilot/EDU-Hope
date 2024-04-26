package com.teamproject1.scuoledevelhope.classes.userRegistry.repo;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistryDAO extends JpaRepository<UserRegistry, Long> {

    // VISUALIZZA TUTTI GLI USER CHE PARTECIPANO AD UN MEETING
    @Query(value = "select * from user_registry\n" +
            "join user_meeting on user_registry.user_id  = user_meeting.id_user\n" +
            "where user_meeting.id_meeting  =:id", nativeQuery = true)
    List<UserRegistry> allUserByMeeting(@Param("id") Long id);
}
