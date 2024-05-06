package com.teamproject1.scuoledevelhope.classes.tutor.service;

import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.dto.TutorDto;
import com.teamproject1.scuoledevelhope.classes.tutor.dto.TutorDtoList;
import com.teamproject1.scuoledevelhope.classes.tutor.dto.TutorMapper;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorService {

    private final TutorDAO tutorDAO;

    private final UserDao userDao;

    private final TutorMapper tutorMapper;

    public TutorService(TutorDAO tutorDAO, UserDao userDao, TutorMapper tutorMapper) {
        this.tutorDAO = tutorDAO;
        this.userDao = userDao;
        this.tutorMapper = tutorMapper;
    }


    public TutorDtoList findAll(int limit, int page) {
        Page<Tutor> tutors = tutorDAO.findAll(PageRequest.of(page, limit));
        return TutorDtoList.TutorDtoListBuilder.aTutorDtoList()
                .withTutors(tutorMapper.toListTutorDto(tutors.toList()))
                .withTotalElements(tutors.getTotalElements())
                .withPage(tutors.getPageable().getPageNumber())
                .withPageSize(tutors.getPageable().getPageSize())
                .withTotalPages(tutors.getTotalPages())
                .withHttpStatus(HttpStatus.OK)
                .build();
    }

    public BaseResponseElement<TutorDto> findById(Long id) {
        Optional<Tutor> result = tutorDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Tutor was not present");
        }
        return new BaseResponseElement<>(tutorMapper.tutorToTutorDto(result.get()));
    }

    public BaseResponseElement<TutorDto> save(String username) {
        Tutor tutor = tutorDAO.save(tutorMapper.userToTutor(userDao.getByUsername(username)));
        return new BaseResponseElement<>(tutorMapper.tutorToTutorDto(tutor));
    }

    public BaseResponseElement<TutorDto> deleteById(Long id) {
        Optional<Tutor> temp = tutorDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Tutor was not present");
        }
        tutorDAO.deleteById(id);

        return new BaseResponseElement<>(tutorMapper.tutorToTutorDto(temp.get()));
    }


}
