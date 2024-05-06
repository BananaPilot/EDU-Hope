package com.teamproject1.scuoledevelhope.classes.student.service;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDtoList;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentMapper;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    private final UserDao userDao;

    private final RoleDao roleDao;

    private final StudentMapper studentMapper;

    public StudentService(StudentDAO studentDAO, UserDao userDao, RoleDao roleDao, StudentMapper studentMapper) {
        this.studentDAO = studentDAO;
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.studentMapper = studentMapper;
    }

    public StudentDtoList findAll(int limit, int page) {
        Page<Student> students = studentDAO.findAll(PageRequest.of(page, limit));
        return StudentDtoList.StudentDtoListBuilder.aStudentDtoList()
                .withHttpStatus(HttpStatus.OK)
                .withStudents(studentMapper.toStudentDtoList(students.toList()))
                .withPage(students.getPageable().getPageNumber())
                .withPageSize(students.getPageable().getPageSize())
                .withTotalElements(students.getTotalElements())
                .withTotalPages(students.getTotalPages())
                .build();
    }

    public BaseResponseElement<StudentDto> findById(Long id) {
        Optional<Student> result = studentDAO.findById(id);
        if (result.isPresent()) {
            return new BaseResponseElement<>(studentMapper.toStudentDto(result.get()));
        } else {
            throw new SQLException("Student was not present");
        }
    }

    public BaseResponseElement<StudentDto> deleteById(Long id) {
        Optional<Student> temp = studentDAO.findById(id);
        if (temp.isPresent()) {
            studentDAO.deleteById(id);
        } else {
            throw new SQLException("Student was not present");
        }
        return new BaseResponseElement<>(studentMapper.toStudentDto(temp.get()));

    }

    @Transactional
    public BaseResponseElement<StudentDto> save(@Valid String username) {
        Student student = studentMapper.userToStudent(userDao.getByUsername(username));
        roleDao.addRoleWithUsername(username, Role.RoleEnum.STUDENT.getRoleString());
        return new BaseResponseElement<>(studentMapper.toStudentDto(studentDAO.save(student)));
    }

}
