package com.teamproject1.scuoledevelhope.classes.userRegistry.repo;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistryDAO extends JpaRepository<UserRegistry, Long> {

    // VISUALIZZA TUTTI GLI USER CHE PARTECIPANO AD UN MEETING
    @Query(value = "select * from user_registry join user_meeting on user_registry.user_id  = user_meeting.id_user where user_meeting.id_meeting  =:id", nativeQuery = true)
    List<UserRegistry> allUserByMeeting(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into user_registry (user_email, user_name, user_surname, user_telephone, user_id) value (:email, :name, :surname, :phone, :id)", nativeQuery = true)
    int addRegistry(@Param("email") String email, @Param("name") String name, @Param("surname") String surname, @Param("phone") String phone, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update user_registry set user_email = :email, user_name = :name, user_surname = :surname, user_telephone = :phone where user_id = :id", nativeQuery = true)
    int userRegistryUpdate(@Param("email") String email, @Param("name") String name, @Param("surname") String surname, @Param("phone") String phone, @Param("id") Long id);

    @Query(value = "select * from user_registry where user_id = :id", nativeQuery = true)
    UserRegistry registryById(@Param("id") Long id);
}
