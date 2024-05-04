package com.teamproject1.scuoledevelhope.classes.user.service;

import com.bananapilot.samplespringauthenticationframework.utils.BCryptPasswordEncoder;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleDashboard;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.DashboardDto;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserAdd;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserDtoElement;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserListDto;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    private final UserRegistryDAO userRegistryDAO;

    private final RoleDao roleDao;

    private final Utils utils;

    private final UserMapper mapper = new UserMapper();

    public UserService(UserDao userDao, UserRegistryDAO userRegistryDAO, RoleDao roleDao, Utils utils) {
        this.userDao = userDao;
        this.userRegistryDAO = userRegistryDAO;
        this.roleDao = roleDao;
        this.utils = utils;
    }

    public UserListDto getAll(int pageSize, int page) {
        Page<User> users = userDao.getAll(PageRequest.of(page, pageSize));
        return UserListDto.UserListDtoBuilder.anUserListDto()
                .withUsers(mapper.userDtoList(users.toList()))
                .withPage(users.getPageable().getPageNumber())
                .withPageSize(users.getPageable().getPageSize())
                .withTotalElements(users.getTotalElements())
                .withTotalPages(users.getTotalPages())
                .build();
    }

    public UserDtoElement getByUsername(String username) {
        return UserDtoElement.UserDtoElementBuilder.anUserDtoElement()
                .withUserDto(mapper.userToUserDto(userDao.getByUsername(username)))
                .withMessage("Found")
                .build();
    }

    @Transactional
    public DashboardDto addUser(UserAdd userAdd) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        userAdd.setPassword(encoder.encode(userAdd.getPassword()));

        userDao.addUser(userAdd.getUsername(), userAdd.getPassword());
        User user = userDao.getByUsername(userAdd.getUsername());
        userRegistryDAO.addRegistry(userAdd.getEmail(), userAdd.getName(), userAdd.getSurname(), userAdd.getPhoneNumber(), user.getId());
        userDao.addUserRegistry(user.getId());
        roleDao.addRoleWithUsername(userAdd.getUsername(), Role.RoleEnum.USER.getRoleString());
        user = userDao.getByUsername(userAdd.getUsername());
        return DashboardDto.DashboardDtoBuilder.map(user)
                .withRole(RoleDashboard.RoleDashboardBuilder.map(user.getRoles()).build())
                .withUserRegistry(userRegistryDAO.registryById(user.getId()))
                .withHttpStatus(HttpStatus.CREATED)
                .withMessage("User created")
                .build();
    }


    public DashboardDto getDashboard(String jwt) {
        User user = userDao.userById(utils.getUserFromJwt(jwt).getId());
        return DashboardDto.DashboardDtoBuilder.map(user)
                .withRole(RoleDashboard.RoleDashboardBuilder.map(user.getRoles()).build())
                .build();
    }


    public DashboardDto delete(String jwt) {
        User user = userDao.userById(utils.getUserFromJwt(jwt).getId());
        userDao.deleteUser(user.getId());
        return DashboardDto.DashboardDtoBuilder.map(user)
                .withRole(RoleDashboard.RoleDashboardBuilder.map(user.getRoles()).build())
                .withMessage("User deleted")
                .build();
    }

    @Transactional
    public DashboardDto updateUser(String jwt, UserAdd updatedUser) {
        int userRes = userDao.userUpdate(utils.getUserFromJwt(jwt).getId(), updatedUser.getUsername(), updatedUser.getPassword());
        int userRegistryRes = userRegistryDAO.userRegistryUpdate(updatedUser.getEmail(), updatedUser.getName(), updatedUser.getSurname(), updatedUser.getPhoneNumber(), utils.getUserFromJwt(jwt).getId());
        if (userRes < 0 || userRegistryRes < 0) {
            throw new SQLException("user was not updated");
        }
        User user = userDao.userById(utils.getUserFromJwt(jwt).getId());
        return DashboardDto.DashboardDtoBuilder.map(user)
                .withRole(RoleDashboard.RoleDashboardBuilder.map(user.getRoles()).build())
                .build();
    }
}
