package com.teamproject1.scuoledevelhope.classes.report.repo;

import com.teamproject1.scuoledevelhope.classes.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportDao extends JpaRepository<Report, Long> {
}
