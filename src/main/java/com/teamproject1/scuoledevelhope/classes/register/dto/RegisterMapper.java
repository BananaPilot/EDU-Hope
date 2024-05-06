package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentMapper;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import org.springframework.stereotype.Component;

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
        Register register = new Register();

        register.setSchoolClass(classDAO.getByName(registerDTO.getNameClass()));
        register.setTutor(tutorDAO.findById(registerDTO.getTutorId()).orElse(null));
        register.setSchoolYear(registerDTO.getSchoolYear());
        register.setStudents(studentMapper.toStudentList(registerDTO.getStudents()));
        register.setVotes(voteMapper.toVoteList(registerDTO.getVotes()));

        return register;
    }

    public RegisterDTO toRegisterDto(Register register) {
        RegisterDTO registerDTO = new RegisterDTO();

        registerDTO.setNameClass(register.getSchoolClass().getName());
        registerDTO.setSchoolYear(register.getSchoolYear());
        registerDTO.setTutorId(register.getTutor().getUser().getId());
        registerDTO.setStudents(studentMapper.toStudentDtoList(register.getStudents()));
        registerDTO.setVotes(voteMapper.toVoteDtoList(register.getVotes()));

        return registerDTO;
    }
}
