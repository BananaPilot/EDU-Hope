package com.teamproject1.scuoledevelhope.classes.register.service;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    private final RegisterDao registerDao;

    public RegisterService(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public BaseResponseList<Register> findAll() {
        return new BaseResponseList<>(registerDao.findAll());
    }

    public BaseResponseElement<Register> findById(Long id) {
        Optional<Register> result = registerDao.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Register was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseList<Register> getAllBySchoolYear(String schoolYear) {
        return new BaseResponseList<>(registerDao.getAllBySchoolYear(schoolYear));
    }

    public BaseResponseList<Register> getAllByTutor(Long tutorId) {
        return new BaseResponseList<>(registerDao.getAllByTutor(tutorId));
    }

    public BaseResponseElement<Register> save(Register register) {
        int res = registerDao.addRegister(register.getSchoolYear(), register.getSchoolClass().getId(), register.getTutor().getUser().getId());
        if (res < 1) {
            throw new SQLException("User was not added");
        }
        return new BaseResponseElement<>(register);
    }

    public BaseResponseElement<Register> deleteById(Long id) {
        Optional<Register> temp = registerDao.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Register was not present");
        }
        registerDao.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }

}
