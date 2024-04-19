package com.teamproject1.scuoledevelhope.classes.tutor.service;

import com.teamproject1.scuoledevelhope.classes.tutor.DAO.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TutorService {

    private final TutorDAO tutorDAO;

    public TutorService(TutorDAO tutorDAO) {
        this.tutorDAO = tutorDAO;
    }


    public BaseResponseList<Tutor> findAll() {
        return new BaseResponseList<>(tutorDAO.findAll());
    }

    public BaseResponseElement<Tutor> findById(Long id) {
        Optional<Tutor> result = tutorDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Tutor was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Tutor> save(Tutor tutor) {
        return new BaseResponseElement<>(tutorDAO.save(tutor));
    }

    public BaseResponseElement<Tutor> deleteById(Long id) {
        Optional<Tutor> temp = tutorDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Tutor was not present");
        }
        tutorDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}
