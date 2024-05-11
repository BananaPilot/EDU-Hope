package com.teamproject1.scuoledevelhope.classes.report.repo;

import com.teamproject1.scuoledevelhope.classes.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDao extends JpaRepository<Report, Long> {

    @Query(value = "select * from report where id_student = :idStudent and subject = :subject", nativeQuery = true)
    Report findByIdStudentAndSubject(@Param("idStudent") Long idStudent, @Param("subject") String subject);
}
