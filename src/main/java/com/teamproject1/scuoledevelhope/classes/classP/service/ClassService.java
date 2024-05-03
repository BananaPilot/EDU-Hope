package com.teamproject1.scuoledevelhope.classes.classP.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassDTO;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDTO;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
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

    public BaseResponseElement<ClassDTO> save(ClassDTO classDTO) {
        Classes classes = classRegisterMapper.toClass(classDTO);
        Register register = classRegisterMapper.toRegister(classDTO);

        classDAO.save(classes);
        registerDao.save(register);

        register.setSchoolClass(classDAO.findById(classes.getId()).orElseThrow(
                ()-> new NotFoundException("class not found")
        ));

        return new BaseResponseElement<>(classDTO);
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
