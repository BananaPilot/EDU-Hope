package com.teamproject1.scuoledevelhope.classes.user.service;

import com.bananapilot.samplespringauthenticationframework.service.UserService;
import com.bananapilot.samplespringauthenticationframework.types.User;
import com.teamproject1.scuoledevelhope.classes.user.dao.UserDaoInternal;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.BadRequestException;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import com.teamproject1.scuoledevelhope.types.errors.NullValueException;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoInternal userDao;


    @Override
    public User checkCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new NullValueException("username or password were null");
        }
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            throw new NotFoundException("User not found with credentials given");
        }
        if (!password.equals(user.getPassword())) {
            throw new BadRequestException("Password is incorrect");
        }
        return user;
    }

    public BaseResponseList<User> getAll() {
        return new BaseResponseList<>(userDao.getAll());
    }

    public BaseResponseElement<User> getByUsername(String username) {
        return new BaseResponseElement<>(userDao.getUserByUsername(username));
    }

    public BaseResponseElement<User> getById(int id) {
        return new BaseResponseElement<>(userDao.getUserById(id));
    }

    public BaseResponseElement<User> addUser(User user) {
        int res = userDao.addUser(user.getUsername(), user.getPassword());
        System.out.println(res);
        if (res < 1) {
            throw new SQLException("User was not added");
        }
        return new BaseResponseElement<>(user);
    }
}