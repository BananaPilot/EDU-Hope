package com.teamproject1.scuoledevelhope.classes.classP.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
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

    public BaseResponseElement<Classes> findById(Long id) {
        Optional<Classes> result = classDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Classes> save(Classes classes) {
        return new BaseResponseElement<>(classDAO.save(classes));
    }

    public BaseResponseElement<Classes> deleteById(Long id) {
        Optional<Classes> temp = classDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        classDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}
