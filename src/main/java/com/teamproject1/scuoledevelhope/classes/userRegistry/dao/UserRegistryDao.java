/*package com.teamproject1.scuoledevelhope.classes.userRegistry.dao;

import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistryDao extends JpaRepository<UserRegistry, Integer> {
    @Query(value = "select * from user_registry where user.id = :idUser", nativeQuery = true )
    UserRegistry getByIdUser(@Param("idUser") Integer idUser);
}
*/