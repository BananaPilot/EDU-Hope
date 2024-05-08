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

    public RegisterDto toRegisterDto(Register register){
        return RegisterDto.RegisterDtoBuilder.aRegisterDto()
                .withSchoolYear(register.getSchoolYear())
                .withTutorId(register.getTutor() != null? register.getTutor().getUser().getId() : null)
                .withNameClass(register.getSchoolClass().getName())
                .build();
    }

    public List<RegisterDto> toRegisterDtoList(List<Register> registers){
        List<RegisterDto> registerDtoList = new ArrayList<>();
        for(Register element : registers){
            registerDtoList.add(this.toRegisterDto(element));
        }
        return registerDtoList;
    }

    public RegisterDtoWithStudent toRegisterDtoWithStudent(Register register) {

        return RegisterDtoWithStudent.RegisterDtoWithStudentBuilder.aRegisterDtoWithStudent()
                .withRegisterDto(this.toRegisterDto(register))
                .withStudents(studentMapper.toListStudentDto(register.getStudents()))
                .build();
    }

    public RegisterDtoWithVote toRegisterDtoWithVote(Register register) {

        return RegisterDtoWithVote.RegisterDtoWithVoteBuilder.aRegisterDtoWithVote()
                .withRegisterDto(this.toRegisterDto(register))
                .withVotes(voteMapper.toListVoteDto(register.getVotes()))
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
