package com.teamproject1.scuoledevelhope.classes.user.dao;

import com.bananapilot.samplespringauthenticationframework.repo.UserDao;
import com.bananapilot.samplespringauthenticationframework.types.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInternal extends UserDao, JpaRepository<User, Integer> {

    @Query(value = "select * from user u join role_user ru on u.id = ru.user_id join role r on r.type = ru.role_name where u.username = ?", nativeQuery = true)
    @Override
    User getUserByUsername(String username);

    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAll();

    @Query(value = "select * from user u join role_user ru on u.id = ru.user_id join role r on r.type = ru.role_name where u.id = ?", nativeQuery = true)
    User getUserById(int id);

    @Query(value = "insert into user(username, password) values (:username, :password)", nativeQuery = true)
    @Transactional
    @Modifying
    int addUser(@Param("username") String username, @Param("password") String password);
}
