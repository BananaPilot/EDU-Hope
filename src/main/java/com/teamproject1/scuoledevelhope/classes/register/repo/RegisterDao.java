package com.teamproject1.scuoledevelhope.classes.register.repo;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterDao extends JpaRepository<Register, Long> {

}
