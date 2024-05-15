package com.teamproject1.scuoledevelhope.classes.report;

import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.types.Interceptor;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class ReportInterceptor extends Interceptor {

    private final StudentDAO studentDao;
    private final Utils utils;

    public ReportInterceptor(StudentDAO studentDao, Utils utils) {
        this.studentDao = studentDao;
        this.utils = utils;
    }

    @Override
    public boolean handle(HttpServletRequest request) throws IOException {
        Student student = utils.isPresent(studentDao.findById(utils.getUserFromJwt(request.getHeader("Authorization")).getId()));

        if("GET".equals(request.getMethod())){
            Long idStudent = Long.parseLong(request.getParameter("idStudent"));

            return student.getId().equals(idStudent);
        }
        return false;
    }
}
