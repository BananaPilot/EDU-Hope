package com.teamproject1.scuoledevelhope.classes.coordinator.service;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorDto;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorDtoList;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorMapper;
import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.user.User;
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
public class CoordinatorService {

    private final CoordinatorDAO coordinatorDAO;
    private final UserDao userDao;
    private final CoordinatorMapper coordinatorMapper = new CoordinatorMapper();

    public CoordinatorService(CoordinatorDAO coordinatorDAO, UserDao userDao) {
        this.coordinatorDAO = coordinatorDAO;
        this.userDao = userDao;
    }


    public CoordinatorDtoList findAll(int limit, int page) {
        Page<Coordinator> coordinators = coordinatorDAO.findAll(PageRequest.of(page, limit));
        return CoordinatorDtoList.CoordinatorDtoListBuilder.aCoordinatorDtoList()
                .withCoordinators(coordinatorMapper.toCoordinatorDtoList(coordinators.toList()))
                .withPage(coordinators.getPageable().getPageNumber())
                .withPageSize(coordinators.getPageable().getPageSize())
                .withTotalElements(coordinators.getTotalElements())
                .withTotalPages(coordinators.getTotalPages())
                .withHttpStatus(HttpStatus.OK)
                .build();
    }

    public BaseResponseElement<CoordinatorDto> findById(Long id) {
        Optional<Coordinator> result = coordinatorDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("Coordinator was not present");
        }
        return new BaseResponseElement<>(coordinatorMapper.toCoordinatorDto(result.get()));
    }

    public BaseResponseElement<CoordinatorDto> save(String username) {
        Coordinator coordinator = coordinatorDAO.save(coordinatorMapper.userToCoordinator(userDao.getByUsername(username)));
        return new BaseResponseElement<>(coordinatorMapper.toCoordinatorDto(coordinator));
    }

    public BaseResponseElement<CoordinatorDto> deleteById(Long id) {
        Optional<Coordinator> temp = coordinatorDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("Coordinator was not present");
        }
        coordinatorDAO.deleteById(id);

        return new BaseResponseElement<>(coordinatorMapper.toCoordinatorDto(temp.get()));
    }

}
