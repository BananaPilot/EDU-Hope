package com.teamproject1.scuoledevelhope.classes.meeting.dao;

import com.teamproject1.scuoledevelhope.classes.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MeetingDAO extends JpaRepository<Meeting, Long> {

}
