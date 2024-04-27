package com.teamproject1.scuoledevelhope.classes.user.service;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleDashboard;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.DashboardDto;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserAdd;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    private final UserRegistryDAO userRegistryDAO;

    private final RoleDao roleDao;

    private final Utils utils;

    public UserService(UserDao userDao, UserRegistryDAO userRegistryDAO, RoleDao roleDao, Utils utils) {
        this.userDao = userDao;
        this.userRegistryDAO = userRegistryDAO;
        this.roleDao = roleDao;
        this.utils = utils;
    }

    public BaseResponseList<User> getAll() {
        return new BaseResponseList<>(userDao.getAll());
    }

    public BaseResponseElement<User> getByUsername(String username) {
        return new BaseResponseElement<>(userDao.getByUsername(username));
    }

    @Transactional
    public BaseResponseElement<User> addUser(UserAdd userAdd) {
        int userRes = userDao.addUser(userAdd.getUsername(), userAdd.getPassword());
        User user = userDao.getByUsername(userAdd.getUsername());
        int userRegistryRes = userRegistryDAO.addRegistry(userAdd.getEmail(), userAdd.getName(), userAdd.getSurname(), userAdd.getPhoneNumber(), user.getId());
        userDao.addUserRegistry(user.getId());
        roleDao.addRoleWithUsername(userAdd.getUsername(), Role.RoleEnum.USER.getRoleString());
        if (userRes < 0 || userRegistryRes < 0) {
            throw new SQLException("User was not added");
        }
        return new BaseResponseElement<>(userDao.getByUsername(userAdd.getUsername()));
    }


    public BaseResponseElement<DashboardDto> getDashboard(String jwt) {
        User user = userDao.getByID(utils.getUserFromJwt(jwt).getId());
        DashboardDto dashboardDto = DashboardDto.DashboardDtoBuilder.map(user)
                .withRole(RoleDashboard.RoleDashboardBuilder.map(user.getRoles()).build())
                .build();
        return new BaseResponseElement<>(dashboardDto);
    }

    
    public BaseResponseElement<User> delete(String jwt) {
        User user = userDao.getByID(utils.getUserFromJwt(jwt).getId());
        userDao.deleteUser(user.getId());
        return new BaseResponseElement<>(user);
    }
}
