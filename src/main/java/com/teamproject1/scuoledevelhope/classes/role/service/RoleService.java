package com.teamproject1.scuoledevelhope.classes.role.service;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleUsername;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleDao roleDao;

    private final UserDao userDao;

    public RoleService(RoleDao roleDao, UserDao userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    public BaseResponseElement<User> addRole(RoleUsername roleUsername) {
        int res = roleDao.addRoleWithUsername(roleUsername.getUsername(), roleUsername.getRoleEnum());
        if (res < 1) {
            throw new SQLException("role wasn't added");
        }
        return new BaseResponseElement<>(userDao.getByUsername(roleUsername.getUsername()));
    }

    public BaseResponseElement<User> deleteRole(RoleUsername roleUsername) {
        int res = roleDao.deleteRoleByUsername(roleUsername.getUsername(), roleUsername.getRoleEnum());
        if (res < 1) {
            throw new SQLException("role wasn't deleted");
        }
        return new BaseResponseElement<>(userDao.getByUsername(roleUsername.getUsername()));
    }

    public void addRole(Role role) {
        roleDao.save(role);
    }
}
