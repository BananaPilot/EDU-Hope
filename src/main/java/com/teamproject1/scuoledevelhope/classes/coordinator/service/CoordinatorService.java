package com.teamproject1.scuoledevelhope.classes.coordinator.service;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.dao.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CoordinatorService {

    private final CoordinatorDAO coordinatorDAO;

    public CoordinatorService(CoordinatorDAO coordinatorDAO) {
        this.coordinatorDAO = coordinatorDAO;
    }


    public BaseResponseList<Coordinator> findAll() {
        return new BaseResponseList<>(coordinatorDAO.findAll());
    }

    public BaseResponseElement<Coordinator> findById(Long id) {
        Optional<Coordinator> result = coordinatorDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Coordinator was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Coordinator> save(Coordinator coordinator) {
        return new BaseResponseElement<>(coordinatorDAO.save(coordinator));
    }

    public BaseResponseElement<Coordinator> deleteById(Long id) {
        Optional<Coordinator> temp = coordinatorDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Coordinator was not present");
        }
        coordinatorDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}
