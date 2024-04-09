package com.teamproject1.scuoledevelhope.classes.student.dao;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//cambio endpoint
//@RepositoryRestResource(path="prova")
@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

}
