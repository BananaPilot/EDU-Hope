package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.classP.repo.ClassDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentMapper;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import org.springframework.stereotype.Component;

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

    public Register toRegister(RegisterDto registerDto){

        return Register.RegisterBuilder.aRegister()
                .withSchoolClass(classDAO.getByName(registerDto.getNameClass()))
                .withSchoolYear(registerDto.getSchoolYear())
                .withTutor(tutorDAO.findById(registerDto.getTutorId()).orElse(null))
                .withStudents(studentMapper.toStudentList(registerDto.getStudents()))
                .withVotes(voteMapper.toVoteList(registerDto.getVotes()))
                .build();
    }

    public RegisterDtoWithStudent toRegisterDtoWithStudent(Register register) {

        return RegisterDtoWithStudent.RegisterDtoWithStudentBuilder.aRegisterDtoWithStudent()
                .withNameClass(register.getSchoolClass().getName())
                .withSchoolYear(register.getSchoolYear())
                .withTutorId(register.getTutor().getUser().getId())
                .withStudents(studentMapper.toStudentDtoList(register.getStudents()))
                .build();
    }

    public RegisterDtoWithVote toRegisterDtoWithVote(Register register) {

        return RegisterDtoWithVote.RegisterDTOBuilder.aRegisterDTO()
                .withNameClass(register.getSchoolClass().getName())
                .withSchoolYear(register.getSchoolYear())
                .withTutorId(register.getTutor().getUser().getId())
                .withVotes(voteMapper.toVoteDtoList(register.getVotes()))
                .build();
    }

    public List<RegisterDtoWithStudent> toRegisterDtoListWithStudent(List<Register> registers){
        List<RegisterDtoWithStudent> registerDtoList = new ArrayList<>();
        for(Register element : registers){
            registerDtoList.add(this.toRegisterDtoWithStudent(element));
        }
        return registerDtoList;
    }

    public List<RegisterDtoWithVote> toRegisterDtoListWithVote(List<Register> registers){
        List<RegisterDtoWithVote> registerDtoList = new ArrayList<>();
        for(Register element : registers){
            registerDtoList.add(this.toRegisterDtoWithVote(element));
        }
        return registerDtoList;
    }

    public RegisterDtoListWithStudent registerDtoToRegisterListWithStudent(List<Register> registers){
        RegisterDtoListWithStudent registerDtoList = new RegisterDtoListWithStudent();
        registerDtoList.setRegisterDtoList(this.toRegisterDtoListWithStudent(registers));
        return registerDtoList;
    }

    public RegisterDtoListWithVote registerDtoToRegisterListWithVote(List<Register> registers){
        RegisterDtoListWithVote registerDtoList = new RegisterDtoListWithVote();
        registerDtoList.setRegisterDtoList(this.toRegisterDtoListWithVote(registers));
        return registerDtoList;
    }

}
