package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterDTO;
import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.controller.RegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentMapper;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterMapper {
    private final ClassDAO classDAO;
    private final TutorDAO tutorDAO;
    private final StudentMapper studentMapper;
    private final VoteMapper voteMapper;
    public RegisterMapper(ClassDAO classDAO, TutorDAO tutorDAO, StudentMapper studentMapper, VoteMapper voteMapper) {
        this.classDAO = classDAO;
        this.tutorDAO = tutorDAO;
        this.studentMapper = studentMapper;
        this.voteMapper = voteMapper;
    }

    public Register toRegister(RegisterDTO registerDTO){

        return Register.RegisterBuilder.aRegister()
                .withSchoolClass(classDAO.getByName(registerDTO.getNameClass()))
                .withSchoolYear(registerDTO.getSchoolYear())
                .withTutor(tutorDAO.findById(registerDTO.getTutorId()).orElse(null))
                .withStudents(studentMapper.toStudentList(registerDTO.getStudents()))
                .withVotes(voteMapper.toVoteList(registerDTO.getVotes()))
                .build();
    }

    public RegisterDTO toRegisterDto(Register register) {

        return RegisterDTO.RegisterDTOBuilder.aRegisterDTO()
                .withNameClass(register.getSchoolClass().getName())
                .withSchoolYear(register.getSchoolYear())
                .withTutorId(register.getTutor().getUser().getId())
                .withStudents(studentMapper.toStudentDtoList(register.getStudents()))
                .withVotes(voteMapper.toVoteDtoList(register.getVotes()))
                .build();
    }

    public List<RegisterDTO> toRegisterDtoList(List<Register> registers){
        List<RegisterDTO> registerDtoList = new ArrayList<>();
        for(Register element : registers){
            registerDtoList.add(this.toRegisterDto(element));
        }
        return registerDtoList;
    }

    public RegisterDtoList registerDtoToRegisterList(List<Register> registers){
        RegisterDtoList registerDtoList = new RegisterDtoList();
        registerDtoList.setRegisterDtoList(this.toRegisterDtoList(registers));
        return registerDtoList;
    }

}
