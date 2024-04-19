package com.teamproject1.scuoledevelhope.classes.coordinator.service;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.dao.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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

    public BaseResponseElement<Coordinator> findById(UUID id) {
        Optional<Coordinator> result = coordinatorDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Coordinator was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Coordinator> save(Coordinator coordinator) {
        return new BaseResponseElement<>(coordinatorDAO.save(coordinator));
    }

    public BaseResponseElement<Coordinator> deleteById(UUID id) {
        Optional<Coordinator> temp = coordinatorDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Coordinator was not present");
        }
        coordinatorDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }

    public BaseResponseElement<Coordinator> save(@Valid Coordinator coordinator, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            StringBuilder errorMessage = new StringBuilder("Errore di validazione: ");
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            return new BaseResponseElement<>(null, errorMessage.toString(), false);
        }

        Coordinator savedCoordinator = coordinatorDAO.save(coordinator);

        return new BaseResponseElement<>(savedCoordinator, "Coordinatore salvato con successo", true);
    }
}
