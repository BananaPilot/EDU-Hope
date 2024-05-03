package com.teamproject1.scuoledevelhope.framework;

import com.bananapilot.samplespringauthenticationframework.service.UserDetailsService;
import com.bananapilot.samplespringauthenticationframework.types.UserDetails;
import com.bananapilot.samplespringauthenticationframework.utils.BCryptPasswordEncoder;
import com.teamproject1.scuoledevelhope.types.errors.BadRequestException;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsDaoImpl userDetailsDao;


    @Override
    public UserDetails checkCredentials(String username, String password) {
        UserDetails userDetails = userDetailsDao.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userDetails == null) {
            throw new NotFoundException("UserDetails not found");
        }
        if (!encoder.matches(password, userDetails.getPassword())) {
            throw new BadRequestException("Password is incorrect");
        }
        return userDetails;
    }
}
