package com.teamproject1.scuoledevelhope.classes.coordinator.service;

import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorDto;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorDtoList;
import com.teamproject1.scuoledevelhope.classes.coordinator.dto.CoordinatorMapper;
import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoordinatorService {

    private final CoordinatorDAO coordinatorDAO;
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final CoordinatorMapper coordinatorMapper;

    public CoordinatorService(CoordinatorDAO coordinatorDAO, UserDao userDao, RoleDao roleDao, CoordinatorMapper coordinatorMapper) {
        this.coordinatorDAO = coordinatorDAO;
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.coordinatorMapper = coordinatorMapper;
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

    @Transactional
    public BaseResponseElement<CoordinatorDto> save(String username) {
        Coordinator coordinator = coordinatorDAO.save(coordinatorMapper.userToCoordinator(userDao.getByUsername(username)));
        roleDao.addRoleWithUsername(username, Role.RoleEnum.COORDINATOR.getRoleString());
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
