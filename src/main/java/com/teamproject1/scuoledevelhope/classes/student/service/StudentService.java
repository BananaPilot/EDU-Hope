package com.teamproject1.scuoledevelhope.classes.student.service;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public BaseResponseList<Student> findAll() {
        return new BaseResponseList<>(studentDAO.findAll());
    }

    public BaseResponseElement<Student> findById(Long id) {
        Optional<Student> result = studentDAO.findById(id);
        if (result.isPresent()) {
            return new BaseResponseElement<>(result.get());
        } else {
            throw new SQLException("Student was not present");
        }
    }

    public BaseResponseElement<Student> deleteById(Long id) {
        Optional<Student> temp = studentDAO.findById(id);
        if (temp.isPresent()) {
            studentDAO.deleteById(id);
        } else {
            throw new SQLException("Student was not present");
        }
        return new BaseResponseElement<>(temp.get());
    }

}
