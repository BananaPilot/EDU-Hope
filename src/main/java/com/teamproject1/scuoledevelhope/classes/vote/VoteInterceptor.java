package com.teamproject1.scuoledevelhope.classes.vote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
import com.teamproject1.scuoledevelhope.types.Interceptor;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class VoteInterceptor extends Interceptor {
    private final Utils utils;
    private final TutorDAO tutorDAO;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StudentDAO studentDAO;

    public VoteInterceptor(Utils utils, TutorDAO tutorDAO, StudentDAO studentDAO) {
        this.utils = utils;
        this.tutorDAO = tutorDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public boolean handle(HttpServletRequest request) throws IOException {
        Tutor tutor = utils.isPresent(tutorDAO.findById(utils.getUserFromJwt(request.getHeader("Authorization")).getId()));

        if("POST".equals(request.getMethod())){
            VoteDto voteDto = objectMapper.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), VoteDto.class);

            for(Register element : tutor.getRegisters()){
                if(element.getId().equals(voteDto.getIdRegister())) return true;
            }
            return false;

            
        }
        if("GET".equals(request.getMethod())){
            Student student = utils.isPresent(studentDAO.findById(Long.parseLong(request.getRequestURI().split("/")[2])));

            return student.getRegister().getTutor().equals(tutor);
        }

        if("DELETE".equals(request.getMethod())){
            Long idStudent = Long.parseLong(request.getParameter("idStudent"));
            Student student = utils.isPresent(studentDAO.findById(idStudent));

            return student.getRegister().getTutor().equals(tutor);
        }
        return false;
    }
}
