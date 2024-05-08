package com.teamproject1.scuoledevelhope.classes.register;

import com.teamproject1.scuoledevelhope.classes.register.repo.RegisterDao;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterInterceptor implements HandlerInterceptor {

    private final PathMatcher pathMatcher = new AntPathMatcher();

    private final RegisterDao registerDao;

    private final TutorDAO tutorDAO;

    private final Utils utils;

    public RegisterInterceptor(RegisterDao registerDao, TutorDAO tutorDAO, Utils utils) {
        this.registerDao = registerDao;
        this.tutorDAO = tutorDAO;
        this.utils = utils;
    }

    @Transactional
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!includePath(request)) return true;
        if (includePath(request) && handle(request, response)) return true;
        response.sendError(403, "Forbidden");
        return false;
    }

    @Transactional
    public boolean handle(HttpServletRequest request, HttpServletResponse response) {
        Long registerId = Long.parseLong(request.getRequestURI().split("/")[3]);
        Register register = registerDao.findById(registerId).get();
        Tutor tutor = tutorDAO.findById(utils.getUserFromJwt(request.getHeader("Authorization")).getId()).get();
        for (Register registersInTutor : tutor.getRegisters()) {
            if (registersInTutor.getId().equals(registerId)) return true;
        }
        return false;
    }

    public boolean includePath(HttpServletRequest request) {
        List<String> paths = new ArrayList<>();
        paths.add("/register/all-student/**");
        paths.add("/register/all-vote/**");
        boolean bool = false;

        for (String path: paths) {
            if (pathMatcher.match(path, request.getRequestURI())){
                bool = true;
                break;
            }
        }
        return bool;
    }
}
