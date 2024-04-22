package com.teamproject1.scuoledevelhope.classes.userRegistry.service;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistryService {

    private final UserRegistryDAO userRegistryDAO;

    public UserRegistryService(UserRegistryDAO userRegistryDAO) {
        this.userRegistryDAO = userRegistryDAO;
    }

    public BaseResponseList<UserRegistry> findAll() {
        return new BaseResponseList<>(userRegistryDAO.findAll());
    }

    public BaseResponseElement<UserRegistry> findById(Long id) {
        Optional<UserRegistry> result = userRegistryDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("UserRegistry was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<UserRegistry> save(UserRegistry userRegistry) {
        return new BaseResponseElement<>(userRegistryDAO.save(userRegistry));
    }

    public BaseResponseElement<UserRegistry> deleteById(Long id) {
        Optional<UserRegistry> temp = userRegistryDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("UserRegistry was not present");
        }
        userRegistryDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}
