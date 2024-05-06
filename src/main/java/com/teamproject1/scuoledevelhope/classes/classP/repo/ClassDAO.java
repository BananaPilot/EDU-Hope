package com.teamproject1.scuoledevelhope.classes.classP.repo;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDAO extends JpaRepository<Classes, Long> {

}
