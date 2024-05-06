package com.teamproject1.scuoledevelhope.classes.vote.dto;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.vote.Vote;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class VoteMapper {
    private final ModelMapper modelMapper;
    private final RegisterDao registerDao;
    private final StudentDAO studentDao;

    public VoteMapper(ModelMapper modelMapper, RegisterDao registerDao, StudentDAO studentDAO) {
        this.modelMapper = modelMapper;
        this.registerDao = registerDao;
        this.studentDao = studentDAO;
    }


    public Vote toVote(VoteDTO voteDto) {
        TypeMap<VoteDTO, Vote> propertyMapper = this.modelMapper.createTypeMap(VoteDTO.class, Vote.class);
        Vote vote = new Vote();

        Register register = registerDao.findById(voteDto.getIdRegister()).orElse(null);
        Student student = studentDao.findById(voteDto.getIdStudent()).orElse(null);

        vote.setIdRegister(register);
        vote.setIdStudent(student);

        propertyMapper.map(voteDto, vote);
        return vote;
    }

    public VoteDTO toVoteDto(Vote vote) {
        TypeMap<Vote, VoteDTO> propertyMapper = this.modelMapper.createTypeMap(Vote.class, VoteDTO.class);

        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getIdRegister().getId(), VoteDTO::setIdRegister)
        );
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getIdStudent().getId(), VoteDTO::setIdStudent)
        );

        return propertyMapper.map(vote);
    }

}
