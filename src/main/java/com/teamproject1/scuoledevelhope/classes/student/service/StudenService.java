package com.teamproject1.scuoledevelhope.classes.student.service;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.dao.StudentDao;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudenService {

    @Autowired
    StudentDao studentDao;
    public StudenService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public BaseResponseList<Student> findAll(){
        return new BaseResponseList<>(studentDao.findAll());
    }
    public Student findById(int id){

        Optional<Student> result = studentDao.findById(id);
        Student theStudent = null;
        if(result.isPresent()){
            theStudent = result.get();
        }else{
            //TDOD EXCEPTION
        }
        return theStudent;
    }

    public Student save(Student theStudent){
        return studentDao.save(theStudent);
    }

    public void deleteById(int theId){
        studentDao.deleteById(theId);};

}
