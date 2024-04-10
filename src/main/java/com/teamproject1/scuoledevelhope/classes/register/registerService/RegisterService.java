package com.teamproject1.scuoledevelhope.classes.register.registerService;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.registerDAO.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RegisterService {

    RegisterDao registerDao;

    public RegisterService(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public BaseResponseList<Register> findAll(){
        return new BaseResponseList<>(registerDao.findAll());
    }

    public BaseResponseElement<Register> findById(Integer id){
        Optional<Register> result = registerDao.findById(id);
        if(result.isEmpty()){
            throw new SQLException("Register was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseList<Register> getAllBySchoolYear(String schoolYear){
        return new BaseResponseList<>(registerDao.getAllBySchoolYear(schoolYear));
    }

    public BaseResponseList<Register> getAllByTutor(Integer tutorId){
        return new BaseResponseList<>(registerDao.getAllByTutor(tutorId));
    }

    public BaseResponseElement<Register> save(Register register) {
        int res = registerDao.addRegister(register.getSchoolYear(), register.getCl(), register.getTutor());
        if (res < 1) {
            throw new SQLException("User was not added");
        }
        return new BaseResponseElement<>(register);
    }

    public BaseResponseElement<Register> deleteById(Integer id){
        Optional<Register> temp = registerDao.findById(id);

        if(temp.isEmpty()){
            throw new SQLException("Register was not present");
        }
        registerDao.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }

}
