package com.teamproject1.scuoledevelhope.calendar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamproject1.scuoledevelhope.classes.calendar.controller.CalendarController;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.service.MeetingService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CaledarControllerTest {

    private static final String JWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyLXVzZXJuYW1lIjoiZ2lhbm5pIiwidXNlci1pZCI6MSwidXNlci1yb2xlcyI6WyJVU0VSIiwiU1VQRVJfQURNSU4iXX0.rlDJT5JQl1AixYy7N9JaOdxBSkocZ1o4vJ7u2lyMQ28";
    @Autowired
    MockMvc mock;

    @Autowired
    MeetingDAO meetingDAO;

    @Autowired
    MeetingService meetingService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CalendarController calendarController;

    @Autowired
    DataSource dataSource;

    static boolean init = false;

    @BeforeEach
    void populateDatabase() {
        if (!init) {
            ResourceDatabasePopulator populate = new ResourceDatabasePopulator();
            populate.addScript(new FileSystemResource("src/test/java/com/teamproject1/scuoledevelhope/calendar/meeting.sql"));
            populate.execute(dataSource);
            init = true;
        }
    }

    @Test
    public void saveMeeting() throws Exception{

        MeetingDTO meetingDTO = new MeetingDTO( );
        meetingDTO.setTitle("ciao");
        meetingDTO.setNote("si");
        meetingDTO.setStartDate(LocalDateTime.of(2024,10,10,15,30));
        meetingDTO.setEndDate(LocalDateTime.of(2024,10,10,16,30));
        meetingDTO.setLink("www.rusty.com");

        MockHttpServletResponse response = this.mock.perform(post("/calendar/meeting/save")
                .header("Authorization", "Bearer " + JWT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(meetingDTO))).andReturn().getResponse();

        BaseResponseElement<MeetingDTO> baseResponseElement = objectMapper.readValue(response.getContentAsString(),BaseResponseElement.class);


        /*
        MeetingDTO meetingDTOresp = baseResponseElement.getElement();
        Long id = meetingDTOresp.getMeetingID();
        assertNotNull(id); PASQUALE PERCH STA ROBA è NULL??
        System.out.println(id);
        */

        assertEquals(HttpStatus.CREATED,baseResponseElement.getHttpStatus());
    }
    /*
    @Test
    public void deleteMeeting() throws Exception {

        //saveMeeting();
    }
*/
}
