package com.teamproject1.scuoledevelhope.classes.meeting.dao;

import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MeetingDAO extends JpaRepository<Meeting, Long> {
    @Query(nativeQuery = true, value = "")
    List<Meeting> getAllById(@Param("id") Long id);

    @Query(nativeQuery = true, value = " where ms.id_student = :id and meeting.start_date > :startDate and meeting.start_date < :endDate")
    List<Meeting> getMeetingsInInterval(@Param("id") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
