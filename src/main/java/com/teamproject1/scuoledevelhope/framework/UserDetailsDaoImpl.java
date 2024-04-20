package com.teamproject1.scuoledevelhope.framework;

import com.bananapilot.samplespringauthenticationframework.repo.UserDetailsDao;
import com.bananapilot.samplespringauthenticationframework.types.UserDetails;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dao.UserDao;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails getUserByUsername(String username) {
        User user = userDao.getByUsername(username);
        if (user == null) {
            throw new NotFoundException("User was not found");
        }
        return UserDetails.UserDetailsBuilder.anUserDetails()
                .withId(user.getId())
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .withRoles(Collections.singletonList(user.getRoles().toString()))
                .build();
    }
}
