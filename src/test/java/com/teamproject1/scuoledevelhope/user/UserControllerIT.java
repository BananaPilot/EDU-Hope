package com.teamproject1.scuoledevelhope.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.role.repo.RoleDao;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.*;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.classes.user_registry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerIT {

    private static final String JWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyLXVzZXJuYW1lIjoiZ2lhbm5pIiwidXNlci1pZCI6MSwidXNlci1yb2xlcyI6WyJVU0VSIiwiU1VQRVJfQURNSU4iXX0.rlDJT5JQl1AixYy7N9JaOdxBSkocZ1o4vJ7u2lyMQ28";

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserDao userDao;

    @Autowired
    UserRegistryDAO userRegistryDAO;

    @Autowired
    DataSource dataSource;

    @Autowired
    Utils utils;

    @Autowired
    RoleDao roleDao;

    static boolean init = false;

    @BeforeEach
    void populateDatabase() {
        if (!init) {
            ResourceDatabasePopulator populate = new ResourceDatabasePopulator();
            populate.addScript(new FileSystemResource("src/test/java/com/teamproject1/scuoledevelhope/user/roles.sql"));
            populate.execute(dataSource);
            init = true;
        }
    }

    private User createUserForLogin() {
        return userDao.getByUsername("gianni");
    }

    private User addRoleToUser() {
        roleDao.addRoleWithUsername("gianni", Role.RoleEnum.SUPER_ADMIN.getRoleString());
        return userDao.getByUsername("gianni");
    }

    public User createUser() {
        return User.UserBuilder.anUser()
                .withId(1L)
                .withUsername("gianni")
                .withPassword("GianniBello2!")
                .build();
    }

    private UserAdd createAUserAdd() {
        return UserAdd.UserAddBuilder.anUserAdd()
                .withUsername("gianni")
                .withPassword("gianniBello200!")
                .withEmail("gianniBello@gmail.com")
                .withName("gianni")
                .withSurname("bello")
                .withPhoneNumber("+393298325095")
                .build();
    }

    @Test
    @Order(1)
    void aUserPost() throws Exception {
        UserAdd userAdd = createAUserAdd();
        MvcResult res = this.mock.perform(post("/user/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userAdd))
                )
                .andDo(print())
                .andExpect(status().is(201))
                .andReturn();

        DashboardDto dashboardDto = objectMapper.readValue(res.getResponse().getContentAsString(), DashboardDto.class);
        System.out.println(dashboardDto.getRole());
        assertEquals(userAdd.getUsername(), dashboardDto.getUsername());
        assertEquals(userAdd.getEmail(), dashboardDto.getUserRegistry().getEmail());
        assertEquals(userAdd.getName(), dashboardDto.getUserRegistry().getName());
        assertEquals(userAdd.getSurname(), dashboardDto.getUserRegistry().getSurname());
    }

    @Test
    void getLogin() throws Exception {
        User user = createUserForLogin();


        MvcResult res = this.mock.perform(multipart("/user/login").contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("username", user.getUsername())
                        .param("password", "gianniBello200!")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String jwt = res.getResponse().getHeader("Authorization");
        LoginResponse loginResponse = objectMapper.readValue(res.getResponse().getContentAsString(), LoginResponse.class);
        String toConvert = "Bearer " + jwt;
        User userRes = utils.getUserFromJwt(toConvert);

        assertEquals(user.getUsername(), userRes.getUsername());
        assertEquals(user.getId(), userRes.getId());
        assertEquals(toConvert, loginResponse.getJwt());
    }

    @Test
    void getByUsername() throws Exception {
        User user = addRoleToUser();
        MvcResult res = this.mock.perform(get("/user/{username}", user.getUsername()).header("Authorization", "Bearer " + JWT))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        UserDtoElement userDto = objectMapper.readValue(res.getResponse().getContentAsString(), UserDtoElement.class);
        assertEquals(user.getUsername(), userDto.getUser().getUsername());
        assertEquals(user.getId(), userDto.getUser().getId());
    }

    @Test
    void getAll() throws Exception {
        MvcResult res = this.mock.perform(get("/user/all")
                        .param("limit", "2")
                        .param("page", "0")
                        .header("Authorization", "Bearer " + JWT))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        UserListDto userListDto = objectMapper.readValue(res.getResponse().getContentAsString(), UserListDto.class);

        assertEquals(2, userListDto.getPageSize());
        assertEquals(0, userListDto.getPage());
        assertEquals("authenticated", res.getResponse().getHeader("Authorization"));
    }

    @Test
    void getDashboard() throws Exception {
        MvcResult res = this.mock.perform(get("/user/dashboard")
                        .header("Authorization", "Bearer " + JWT))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> result.getRequest().getHeader("Authorization").equals("authenticated"))
                .andReturn();

        DashboardDto dashboardDto = objectMapper.readValue(res.getResponse().getContentAsString(), DashboardDto.class);

        assertNotNull(dashboardDto.getRole(), "user role is null");
        assertNotNull(dashboardDto.getUserRegistry(), "user registry is null");
        assertNotNull(dashboardDto.getUsername(), "username is null");

        User user = utils.getUserFromJwt("Bearer " + JWT);

        assertEquals(user.getUsername(), dashboardDto.getUsername());
        assertEquals(user.getId(), userDao.getByUsername(dashboardDto.getUsername()).getId());
    }
}
