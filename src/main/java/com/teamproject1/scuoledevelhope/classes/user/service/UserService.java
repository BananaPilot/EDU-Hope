package com.teamproject1.scuoledevelhope.classes.user.service;

import com.bananapilot.samplespringauthenticationframework.utils.BCryptPasswordEncoder;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleDashboard;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleMapper;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.*;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.classes.user_registry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import com.teamproject1.scuoledevelhope.utils.Utils;
import jakarta.servlet.http.HttpServletResponse;
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

    private final HttpServletResponse servletResponse;

    private final Utils utils;

    private final RoleMapper roleMapper = new RoleMapper();

    private final UserMapper mapper = new UserMapper();

    public UserService(UserDao userDao, UserRegistryDAO userRegistryDAO, RoleDao roleDao, HttpServletResponse servletResponse, Utils utils) {
        this.userDao = userDao;
        this.userRegistryDAO = userRegistryDAO;
        this.roleDao = roleDao;
        this.servletResponse = servletResponse;
        this.utils = utils;
    }

    public UserListDto getAll(int limit, int page) {
        Page<User> users = userDao.getAll(PageRequest.of(page, limit));
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
        return DashboardDto.DashboardDtoBuilder.aDashboardDto()
                .withUsername(user.getUsername())
                .withUserRegistry(user.getUserRegistry())
                .withRole(RoleDashboard.RoleDashboardBuilder.aRoleDashboard()
                        .withRoleEnum(roleMapper.toRoleEnumList(user.getRoles()))
                        .build()
                )
                .withHttpStatus(HttpStatus.CREATED)
                .withMessage("User created")
                .build();
    }


    public DashboardDto getDashboard(String jwt) {
        User user = userDao.userById(utils.getUserFromJwt(jwt).getId());
        return DashboardDto.DashboardDtoBuilder.aDashboardDto()
                .withUsername(user.getUsername())
                .withUserRegistry(user.getUserRegistry())
                .withRole(RoleDashboard.RoleDashboardBuilder.aRoleDashboard()
                        .withRoleEnum(roleMapper.toRoleEnumList(user.getRoles()))
                        .build()
                )
                .build();
    }


    public DashboardDto delete(String jwt) {
        User user = userDao.userById(utils.getUserFromJwt(jwt).getId());
        userDao.deleteUser(user.getId());
        return DashboardDto.DashboardDtoBuilder.aDashboardDto()
                .withUsername(user.getUsername())
                .withUserRegistry(user.getUserRegistry())
                .withMessage("User deleted")
                .withRole(RoleDashboard.RoleDashboardBuilder.aRoleDashboard()
                        .withRoleEnum(roleMapper.toRoleEnumList(user.getRoles()))
                        .build()
                )
                .build();
    }

    @Transactional
    public DashboardDto updateUser(String jwt, UserAdd updatedUser) {
        int userRes = userDao.userUpdate(utils.getUserFromJwt(jwt).getId(), updatedUser.getUsername());
        int userRegistryRes = userRegistryDAO.userRegistryUpdate(updatedUser.getEmail(), updatedUser.getName(), updatedUser.getSurname(), updatedUser.getPhoneNumber(), utils.getUserFromJwt(jwt).getId());
        if (userRes < 0 || userRegistryRes < 0) {
            throw new SQLException("user was not updated");
        }
        User user = userDao.userById(utils.getUserFromJwt(jwt).getId());
        return DashboardDto.DashboardDtoBuilder.aDashboardDto()
                .withUsername(user.getUsername())
                .withUserRegistry(user.getUserRegistry())
                .withRole(RoleDashboard.RoleDashboardBuilder.aRoleDashboard()
                        .withRoleEnum(roleMapper.toRoleEnumList(user.getRoles()))
                        .build()
                )
                .build();
    }

    public LoginResponse getJwtHeaderResponse() {
        return LoginResponse.LoginResponseBuilder.aLoginResponse()
                .withElement("Bearer " + servletResponse.getHeader("Authorization"))
                .withHttpStatus(HttpStatus.OK)
                .withDescription("The jwt is also in the Authorization header")
                .withMessage("jwt has been created")
                .build();
    }
}
