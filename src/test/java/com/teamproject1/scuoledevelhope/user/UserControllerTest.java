package com.teamproject1.scuoledevelhope.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dto.DashboardDto;
import com.teamproject1.scuoledevelhope.classes.user.dto.UserAdd;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {

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
    void userPost() throws Exception {
        UserAdd userAdd = createAUserAdd();
        MvcResult res = this.mock.perform(post("/user/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userAdd))
                )
                .andDo(print())
                .andExpect(status().is(201))
                .andReturn();

        DashboardDto dashboardDto = objectMapper.readValue(res.getResponse().getContentAsString(), DashboardDto.class);
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
                        .param("id", user.getId().toString())
                )
                .andDo(print())
                .andReturn();

        String jwt = res.getResponse().getHeader("Authorization");
        String toConvert = "Bearer " + jwt;
        User userRes = utils.getUserFromJwt(toConvert);

        assertEquals(user.getUsername(), userRes.getUsername());
        assertEquals(user.getId(), userRes.getId());
    }
}
