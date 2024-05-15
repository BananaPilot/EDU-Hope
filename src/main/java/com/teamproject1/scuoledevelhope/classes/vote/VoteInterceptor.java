package com.teamproject1.scuoledevelhope.classes.vote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
import com.teamproject1.scuoledevelhope.types.Interceptor;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class VoteInterceptor extends Interceptor {
    private final Utils utils;
    private final TutorDAO tutorDAO;
    private final StudentDAO studentDAO;
    private final RegisterDao registerDao;

    public VoteInterceptor(Utils utils, TutorDAO tutorDAO, StudentDAO studentDAO,
                           RegisterDao registerDao) {
        this.utils = utils;
        this.tutorDAO = tutorDAO;
        this.studentDAO = studentDAO;
        this.registerDao = registerDao;
    }

    @Override
    public boolean handle(HttpServletRequest request) throws IOException {
        Tutor tutor = utils.isPresent(tutorDAO.findById(utils.getUserFromJwt(request.getHeader("Authorization")).getId()));

        if("POST".equals(request.getMethod())){
            Long registerId = Long.parseLong(request.getParameter("idRegister"));
            Assert.notNull(registerId, "Register ID is null");
            Register register = utils.isPresent(registerDao.findById(registerId));
            return tutor.getRegisters().contains(register);
        }
        if("GET".equals(request.getMethod())){
            Student student = utils.isPresent(studentDAO.findById(Long.parseLong(request.getRequestURI().split("/")[2])));
            return student.getRegister().getTutor().equals(tutor);
        }

        if("DELETE".equals(request.getMethod())){
            Long idStudent = Long.parseLong(request.getParameter("idStudent"));
            Assert.notNull(idStudent, "Student ID is null");
            Student student = utils.isPresent(studentDAO.findById(idStudent));
            return student.getRegister().getTutor().equals(tutor);
        }
        return false;
    }
}
