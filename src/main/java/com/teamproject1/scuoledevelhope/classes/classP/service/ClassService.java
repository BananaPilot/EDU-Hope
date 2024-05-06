package com.teamproject1.scuoledevelhope.classes.classP.service;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import jakarta.transaction.Transactional;
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

    public BaseResponseElement<ClassRegisterDTO> save(ClassRegisterDTO classDTO) {
        Classes classes = classRegisterMapper.toClass(classDTO);
        Register register = classRegisterMapper.toRegister(classDTO);

        classDAO.save(classes);

        register.setSchoolClass(classDAO.findById(classes.getId()).orElseThrow(
                ()-> new NotFoundException("class not found")
        ));

        registerDao.save(register);

        return new BaseResponseElement<>(classDTO);
    }
    @Transactional
    public BaseResponseElement<ClassRegisterDTO> deleteById(Long id) {
        Optional<Classes> classes = classDAO.findById(id);
        Optional<Register> register = registerDao.findById(id);

        if (classes.isEmpty()) {
            throw new SQLException("Class was not present");
        }
        if (register.isEmpty()){
            throw new SQLException("Register was not present");
        }
        ClassRegisterDTO temp = classRegisterMapper.toClassRegisterDTO(classes.get());

        registerDao.deleteById(id);
        classDAO.deleteById(id);

        return new BaseResponseElement<>(temp);
    }
}
