package com.teamproject1.scuoledevelhope.classes.classP.classService;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.classDAO.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService {
    private final ClassDAO classDAO;

    public ClassService(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    public BaseResponseList<Classes> findAll() {
        return new BaseResponseList<>(classDAO.findAll());
    }

    public BaseResponseElement<Classes> findById(Long id){
        Optional<Classes> result = classDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Classes> save(Classes classes){
        return new BaseResponseElement<>(classDAO.save(classes));
    }

    public BaseResponseElement<Classes> deleteById(Long id){
        Optional<Classes> temp = classDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        classDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }

    public BaseResponseElement<Tutor> getTutorByClass(Long idClass){
        Optional<Classes> result = classDAO.findById(idClass);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseElement<>(classDAO.getTutorByClass(idClass));
    }

    public BaseResponseElement<Coordinator> getCoordinatorByClass(Long idClass){
        Optional<Classes> result = classDAO.findById(idClass);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseElement<>(classDAO.getCoordinatorByClass(idClass));
    }

    public BaseResponseElement<Course> getCourseByClass(Long idClass){
        Optional<Classes> result = classDAO.findById(idClass);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseElement<>(classDAO.getCourseByClass(idClass));
    }

    public BaseResponseList<Student> getStudentsByClass(Long idClass){
        Optional<Classes> result = classDAO.findById(idClass);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseList<>(classDAO.getStudentsByClass(idClass));
    }
}
