package com.teamproject1.scuoledevelhope.classes.classP.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService {
    private final ClassDAO classDAO;
    private final RegisterDao registerDao;
    private final ClassRegisterMapper classRegisterMapper;

    public ClassService(ClassDAO classDAO, RegisterDao registerDao, ClassRegisterMapper classRegisterMapper) {
        this.classDAO = classDAO;
        this.registerDao = registerDao;
        this.classRegisterMapper = classRegisterMapper;
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

    public BaseResponseElement<ClassRegisterDTO> save(ClassRegisterDTO classRegisterDTO) {
        Classes classes = classRegisterMapper.toClass(classRegisterDTO);
        Register register = classRegisterMapper.toRegister(classRegisterDTO);

        classDAO.save(classes);
        registerDao.save(register);

        return new BaseResponseElement<>(classRegisterDTO);
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
