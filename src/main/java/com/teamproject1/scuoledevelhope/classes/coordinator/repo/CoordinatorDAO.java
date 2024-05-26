package com.teamproject1.scuoledevelhope.classes.coordinator.repo;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorDAO extends JpaRepository<Coordinator, Long> {
}
