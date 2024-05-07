package com.teamproject1.scuoledevelhope.classes.role.service;

import com.teamproject1.scuoledevelhope.classes.role.dto.RoleMapper;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleUsername;
import com.teamproject1.scuoledevelhope.classes.role.dto.RolesUser;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleDao roleDao;

    private final UserDao userDao;

    private final RoleMapper roleMapper = new RoleMapper();

    public RoleService(RoleDao roleDao, UserDao userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    public BaseResponseElement<RolesUser> addRole(RoleUsername roleUsername) {
        int res = roleDao.addRoleWithUsername(roleUsername.getUsername(), roleUsername.getRoleEnum().getRoleString());
        if (res < 1) {
            throw new SQLException("role wasn't added");
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
