package com.teamproject1.scuoledevelhope.classes.register.repo;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDao extends JpaRepository<Register, Long> {

}
