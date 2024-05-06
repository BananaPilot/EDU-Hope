package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    private final ClassDAO classDAO;
    private final TutorDAO tutorDAO;

    public RegisterMapper(ClassDAO classDAO, TutorDAO tutorDAO) {
        this.classDAO = classDAO;
        this.tutorDAO = tutorDAO;
    }

    public Register toRegister(RegisterDTO registerDTO){
        Register register = new Register();

        register.setSchoolClass(classDAO.getByName(registerDTO.getNameClass()));
        register.setTutor(tutorDAO.findById(registerDTO.getTutorId()).orElse(null));
        register.setSchoolYear(registerDTO.getSchoolYear());

        return register;
    }

    public RegisterDTO toRegisterDto(Register register) {
        RegisterDTO registerDTO = new RegisterDTO();

        registerDTO.setNameClass(register.getSchoolClass().getName());
        registerDTO.setSchoolYear(register.getSchoolYear());
        registerDTO.setTutorId(register.getTutor().getUser().getId());

        return registerDTO;
    }
}
