package com.teamproject1.scuoledevelhope.framework;

import com.bananapilot.samplespringauthenticationframework.repo.UserDetailsDao;
import com.bananapilot.samplespringauthenticationframework.types.UserDetails;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private UserDao userDao;

    @Transactional
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
                .withRoles(translate(user.getRoles()))
                .build();
    }

    public List<String> translate(List<Role> roles) {
        List<String> myList = new ArrayList<>();
        for (Role role : roles) {
            myList.add(role.getRoleEnum().toString());
        }
        return myList;
    }
}
