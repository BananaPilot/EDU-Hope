package com.teamproject1.scuoledevelhope.classes.student.studentService;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.studentDAO.StudentDAO;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    public BaseResponseList<Student> findAll(){
        return new BaseResponseList<>(studentDAO.findAll());
    }

    public BaseResponseElement<Student> findById(String id){

        UUID tempUUID = UUID.fromString(id);

        Optional<Student> result = studentDAO.findById(tempUUID);
        if(result.isPresent()){
            return new BaseResponseElement<>(result.get());
        }else{
            throw new SQLException("Student was not present");}
    }
    public BaseResponseElement<Student> save(Student theStudent) {
        studentDAO.save(theStudent);
        return new BaseResponseElement<>(theStudent);
    }

    //TODO FIX UPDATES
    public BaseResponseElement<Student> update( String id,Student theStudent) {

        UUID uuid = UUID.fromString(id);
        Student tempStudent = studentDAO.findById(uuid).get();

        tempStudent.setUser(theStudent.getUser());
        tempStudent.setSchoolClass(theStudent.getSchoolClass());
        tempStudent.setRegister(theStudent.getRegister());

        studentDAO.save(tempStudent);
        return new BaseResponseElement<>(tempStudent);
    }

    public BaseResponseElement<Student> deleteById(UUID id){
        Optional<Student> temp = studentDAO.findById(id);
        if(temp.isPresent()){
            studentDAO.deleteById(id);
        }else{
            throw new SQLException("Student was not present");
        }
        return new BaseResponseElement<>(temp.get());
    }

}
