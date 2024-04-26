package com.teamproject1.scuoledevelhope.classes.user.service;

import com.bananapilot.samplespringauthenticationframework.utils.JWTUtils;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleDashboard;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.DashboardDto;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    private final Utils utils;

    public UserService(UserDao userDao, Utils utils) {
        this.userDao = userDao;
        this.utils = utils;
    }

    public BaseResponseList<User> getAll() {
        return new BaseResponseList<>(userDao.getAll());
    }

    public BaseResponseElement<User> getByUsername(String username) {
        return new BaseResponseElement<>(userDao.getByUsername(username));
    }

    public BaseResponseElement<User> addUser(User user) {
        int res = userDao.addUser(user.getUsername(), user.getPassword());
        if (res < 1) {
            throw new SQLException("User was not added");
        }
        return new BaseResponseElement<>(HttpStatus.CREATED, HttpStatus.CREATED.getReasonPhrase(), " ", userDao.getByUsername(user.getUsername()));
    }

    public BaseResponseElement<User> getByID(Long id) {
        return new BaseResponseElement<>(userDao.getByID(id));
    }

    public BaseResponseElement<DashboardDto> getDashboard(String jwt) {
        User user = userDao.getByID(utils.getUserFromJwt(jwt).getId());
        DashboardDto dashboardDto = DashboardDto.DashboardDtoBuilder.aDashboardDto()
                .map(user)
                .withRole(RoleDashboard.RoleDashboardBuilder.aRoleDashboard().map(user.getRoles()).build())
                .build();
        return new BaseResponseElement<>(dashboardDto);
    }
}
