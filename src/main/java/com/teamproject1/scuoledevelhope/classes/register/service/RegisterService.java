package com.teamproject1.scuoledevelhope.classes.register.service;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.dto.*;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    private final RegisterDao registerDao;
    private final RegisterMapper registerMapper;
    private final Utils utils;
    private final TutorDAO tutorDAO;
    public RegisterService(RegisterDao registerDao, RegisterMapper registerMapper, Utils utils, TutorDAO tutorDAO) {
        this.registerDao = registerDao;
        this.registerMapper = registerMapper;
        this.utils = utils;
        this.tutorDAO = tutorDAO;
    }

    public RegisterDtoWithVote findById(Long id) {
        Optional<Register> register = registerDao.findById(id);

        if(register.isEmpty()){
            throw new NotFoundException("Register not found");
        }

        return registerMapper.toRegisterDtoWithVote(register.get()) ;
    }

    public RegisterDtoListWithVote findAllVote(Long registerId, int limit, int page){
        return registerMapper.registerDtoToRegisterListWithVote(registerDao.findAll());
    }

    public RegisterDtoListWithStudent findAllStudent(Long registerId, int limit, int page){
        return registerMapper.registerDtoToRegisterListWithStudent(registerDao.findAll());
    }

    public RegisterDtoList findAllByTutor(String jwt, int limit, int page) {
        Optional<Tutor> optional = tutorDAO.findById(utils.getUserFromJwt(jwt).getId());

        if(optional.isEmpty()){
            throw new NotFoundException("Tutor was not found");
        }
        Tutor tutor = optional.get();

        Page<Register> registers = registerDao.findAllByTutorId(tutor.getUser().getId(), PageRequest.of(page, limit));

        return RegisterDtoList.RegisterDtoListBuilder.aRegisterDtoList()
                .withRegisterDtoList(registerMapper.toRegisterDtoList(registers.toList()))
                .withHttpStatus(HttpStatus.OK)
                .withPage(registers.getPageable().getPageNumber())
                .withPageSize(registers.getPageable().getPageSize())
                .withTotalElements(registers.getTotalElements())
                .withTotalPages(registers.getTotalPages())
                .build();
    }
}
