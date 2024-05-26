package com.teamproject1.scuoledevelhope.classes.report;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.types.Interceptor;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ReportInterceptor extends Interceptor {

    private final StudentDAO studentDao;
    private final TutorDAO tutorDao;
    private final Utils utils;

    public ReportInterceptor(StudentDAO studentDao, TutorDAO tutorDao, Utils utils) {
        this.studentDao = studentDao;
        this.tutorDao = tutorDao;
        this.utils = utils;
    }

    @Override
    public boolean handle(HttpServletRequest request) throws IOException {

        if("GET".equals(request.getMethod())){
            Student student = utils.isPresent(studentDao.findById(utils.getUserFromJwt(request.getHeader("Authorization")).getId()));

            Long idStudent = Long.parseLong(request.getParameter("idStudent"));
            System.out.println(student.getId());
            System.out.println(idStudent);

            return student.getId().equals(idStudent);
        }

        if("PUT".equals(request.getMethod())){
            Tutor tutor = utils.isPresent(tutorDao.findById(utils.getUserFromJwt(request.getHeader("Authorization")).getId()));

            Long idStudent = Long.parseLong(request.getParameter("idStudent"));
            Optional<Student> studentRequest = studentDao.findById(idStudent);

            if(studentRequest.isEmpty()){
                throw new NotFoundException("student not was found");
            }
            return studentRequest.get().getRegister().getTutor().getId().equals(tutor.getId());
        }

        return false;
    }
}
