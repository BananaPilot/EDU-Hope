package com.teamproject1.scuoledevelhope.classes.user.repo;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "select * from user", nativeQuery = true)
    Page<User> getAll(Pageable page);

    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User getByUsername(@Param("username") String username);

    @Query(value = "select * from user where id = :id", nativeQuery = true)
    User getByID(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into user (username, password) values (:username, :password)", nativeQuery = true)
    int addUser(@Param("username") String username, @Param("password") String password);

    @Transactional
    @Modifying
    @Query(value = "update user set user_registry_user_id = :userRegistry where user.id = :userRegistry", nativeQuery = true)
    void addUserRegistry(@Param("userRegistry") Long userRegistry);

    @Transactional
    @Modifying
    @Query(value = "delete from user where id = :id", nativeQuery = true)
    int deleteUser(@Param("id") Long id);
}
