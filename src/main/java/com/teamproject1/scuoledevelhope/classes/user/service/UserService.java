package com.teamproject1.scuoledevelhope.classes.user.service;

import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dao.UserDao;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public BaseResponseList<User> getAll() {
        return new BaseResponseList<>(userDao.getAll());
    }

    public BaseResponseElement<User> getByUsername(String username) {
        return new BaseResponseElement<>(userDao.getByUsername(username));
    }

    public BaseResponseElement<User> addUser(User user) {
        int res = userDao.addUser(user.getId(), user.getUsername(), user.getPassword(), user.getSchool());
        if (res < 1) {
            throw new SQLException("User was not added");
        }
        return new BaseResponseElement<>(HttpStatus.CREATED, HttpStatus.CREATED.getReasonPhrase(), " ", userDao.getByUsername(user.getUsername()));
    }
}
