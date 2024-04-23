package com.teamproject1.scuoledevelhope.classes.meeting.dao;

import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MeetingDAO extends JpaRepository<Meeting, Long> {


    @Query(value = "select m.* from meeting m join defaultdb.user_meeting um on m.id_meeting = um.id_meeting join defaultdb.user u on u.id = um.id_user where u.id = :userId", nativeQuery = true)
    List<Meeting> getAllByID(@Param("userId") Long id);


    @Query(value = "select m.* from meeting m join defaultdb.user_meeting um on m.id_meeting = um.id_meeting join defaultdb.user u on u.id = um.id_user where u.id = :id and m.start_date > :startDate and m.start_date < :endDate", nativeQuery = true)
    List<Meeting> IntervalGetByID(@Param("id") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
