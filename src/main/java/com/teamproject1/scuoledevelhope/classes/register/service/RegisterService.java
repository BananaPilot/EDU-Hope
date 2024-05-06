package com.teamproject1.scuoledevelhope.classes.register.service;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterMapper;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDTO;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    private final RegisterDao registerDao;
    private final RegisterMapper registerMapper;

    public RegisterService(RegisterDao registerDao, RegisterMapper registerMapper) {
        this.registerDao = registerDao;
        this.registerMapper = registerMapper;
    }

    public RegisterDTO findById(Long id) {
        Optional<Register> register = registerDao.findById(id);

        if(register.isEmpty()){
            throw new NotFoundException("Register not found");
        }

        return registerMapper.toRegisterDto(register.get()) ;
    }

}
