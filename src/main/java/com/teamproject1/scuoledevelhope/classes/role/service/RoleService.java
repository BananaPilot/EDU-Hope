package com.teamproject1.scuoledevelhope.classes.role.service;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.coordinator.service.CoordinatorService;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleMapper;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleUsername;
import com.teamproject1.scuoledevelhope.classes.role.dto.RolesUser;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.student.repo.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.student.service.StudentService;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.service.TutorService;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleDao roleDao;

    private final UserDao userDao;

    private final RoleMapper roleMapper = new RoleMapper();
    private final StudentService studentService;
    private final TutorService tutorService;
    private final CoordinatorService coordinatorService;

    public RoleService(RoleDao roleDao, UserDao userDao, StudentService studentService, TutorService tutorService, CoordinatorService coordinatorService) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.studentService = studentService;
        this.tutorService = tutorService;
        this.coordinatorService = coordinatorService;
    }

    public BaseResponseElement<RolesUser> addRole(RoleUsername roleUsername) {
        int res = roleDao.addRoleWithUsername(roleUsername.getUsername(), roleUsername.getRoleEnum().getRoleString());
        if (res < 1) {
            throw new SQLException("role wasn't added");
        }
        switch (roleUsername.getRoleEnum()){
            case STUDENT -> studentService.save(roleUsername.getUsername());
            case TUTOR -> tutorService.save(roleUsername.getUsername());
            case COORDINATOR -> coordinatorService.save(roleUsername.getUsername());
        }

        return new BaseResponseElement<>(roleMapper.toRolesUser(userDao.getByUsername(roleUsername.getUsername())));
    }

    public BaseResponseElement<RolesUser> deleteRole(RoleUsername roleUsername) {
        int res = roleDao.deleteRoleByUsername(roleUsername.getUsername(), roleUsername.getRoleEnum().getRoleString());
        if (res < 1) {
            throw new SQLException("role wasn't deleted");
        }
        return new BaseResponseElement<>(roleMapper.toRolesUser(userDao.getByUsername(roleUsername.getUsername())));
    }
}
