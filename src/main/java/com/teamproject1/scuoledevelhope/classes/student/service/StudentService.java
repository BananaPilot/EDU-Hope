package com.teamproject1.scuoledevelhope.classes.student.service;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.dao.StudentDAO;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public BaseResponseList<Student> findAll() {
        return new BaseResponseList<>(studentDAO.findAll());
    }

    public BaseResponseElement<Student> findById(String id) {

        UUID tempUUID = UUID.fromString(id);

        Optional<Student> result = studentDAO.findById(tempUUID);
        if (result.isPresent()) {
            return new BaseResponseElement<>(result.get());
        } else {
            throw new SQLException("Student was not present");
        }
    }

    public BaseResponseElement<Student> deleteById(UUID id) {
        Optional<Student> temp = studentDAO.findById(id);
        if (temp.isPresent()) {
            studentDAO.deleteById(id);
        } else {
            throw new SQLException("Student was not present");
        }
        return new BaseResponseElement<>(temp.get());
    }

}
