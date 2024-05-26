package com.teamproject1.scuoledevelhope.classes.register.service;

import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDto;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoList;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDtoWithVote;
import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterMapper;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDtoList;
import com.teamproject1.scuoledevelhope.classes.student.dto.StudentMapper;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDtoList;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteMapper;
import com.teamproject1.scuoledevelhope.classes.vote.repo.VoteDAO;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
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
    private final StudentMapper studentMapper;
    private final VoteMapper voteMapper;
    private final Utils utils;
    private final TutorDAO tutorDAO;
    private final StudentDAO studentDAO;
    private final VoteDAO voteDAO;
    private final CoordinatorDAO coordinatorDAO;

    public RegisterService(RegisterDao registerDao, RegisterMapper registerMapper, StudentMapper studentMapper, VoteMapper voteMapper, Utils utils, TutorDAO tutorDAO, StudentDAO studentDAO, VoteDAO voteDAO,
                           CoordinatorDAO coordinatorDAO) {
        this.registerDao = registerDao;
        this.registerMapper = registerMapper;
        this.studentMapper = studentMapper;
        this.voteMapper = voteMapper;
        this.utils = utils;
        this.tutorDAO = tutorDAO;
        this.studentDAO = studentDAO;
        this.voteDAO = voteDAO;
        this.coordinatorDAO = coordinatorDAO;
    }

    public RegisterDtoWithVote findById(Long id) {
        Optional<Register> register = registerDao.findById(id);

        if (register.isEmpty()) {
            throw new NotFoundException("Register was not found");
        }

        return registerMapper.toRegisterDtoWithVote(register.get());
    }

    public VoteDtoList findAllVote(Long registerId, int limit, int page) {
        Page<Vote> votes = voteDAO.findAllByRegisterId(registerId, PageRequest.of(page, limit));
        return VoteDtoList.VoteDtoListBuilder.aVoteDtoList()
                .withVotes(voteMapper.toListVoteDto(votes.toList()))
                .withHttpStatus(HttpStatus.OK)
                .withPage(votes.getPageable().getPageNumber())
                .withPageSize(votes.getPageable().getPageSize())
                .withTotalElements(votes.getTotalElements())
                .withTotalPages(votes.getTotalPages())
                .build();
    }

    public StudentDtoList findAllStudent(Long registerId, int limit, int page) {
        Page<Student> students = studentDAO.findAllByRegisterId(registerId, PageRequest.of(page, limit));
        return StudentDtoList.StudentDtoListBuilder.aStudentDtoList()
                .withStudents(studentMapper.toListStudentDto(students.toList()))
                .withHttpStatus(HttpStatus.OK)
                .withPage(students.getPageable().getPageNumber())
                .withPageSize(students.getPageable().getPageSize())
                .withTotalElements(students.getTotalElements())
                .withTotalPages(students.getTotalPages())
                .build();
    }

    public RegisterDtoList findAllByTutor(String jwt, int limit, int page) {
        Optional<Tutor> optional = tutorDAO.findById(utils.getUserFromJwt(jwt).getId());

        if (optional.isEmpty()) {
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
