package com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryService;

import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryDAO.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserRegistryService {

    UserRegistryDAO userRegistryDAO;

    public UserRegistryService(UserRegistryDAO userRegistryDAO) {
        this.userRegistryDAO = userRegistryDAO;
    }

    public BaseResponseList<UserRegistry> findAll(){
        return new BaseResponseList<>(userRegistryDAO.findAll());
    }

    public BaseResponseElement<UserRegistry> findById(UUID id){
        Optional<UserRegistry> result = userRegistryDAO.findById(id);
        if(result.isEmpty()){
            throw new SQLException("Register was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<UserRegistry> save(UserRegistry userRegistry) {
        return new BaseResponseElement<>(userRegistryDAO.save(userRegistry));
    }

    public BaseResponseElement<UserRegistry> deleteById(UUID id){
        Optional<UserRegistry> temp = userRegistryDAO.findById(id);

        if(temp.isEmpty()){
            throw new SQLException("Register was not present");
        }
        userRegistryDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}
