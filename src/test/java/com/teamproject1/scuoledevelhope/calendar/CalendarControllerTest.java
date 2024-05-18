package com.teamproject1.scuoledevelhope.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamproject1.scuoledevelhope.classes.calendar.controller.CalendarController;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.service.MeetingService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
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
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CalendarControllerTest {

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

        MeetingDTO meetingDTO = new MeetingDTO();
        meetingDTO.setTitle("ciao");
        meetingDTO.setNote("si");
        meetingDTO.setStartDate(LocalDateTime.of(2024,10,10,15,30));
        meetingDTO.setEndDate(LocalDateTime.of(2024,10,10,16,30));
        meetingDTO.setLink("www.rusty.com");

        MockHttpServletResponse response = this.mock.perform(post("/calendar/meeting/save")
                .header("Authorization", "Bearer " + JWT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(meetingDTO))).andReturn().getResponse();

        BaseResponseElement<MeetingDTO> baseResponseElement = objectMapper.readValue(response.getContentAsString(), new TypeReference<BaseResponseElement<MeetingDTO>>() {});

        MeetingDTO meetingDTOresp = baseResponseElement.getElement();
        Long id = meetingDTOresp.getMeetingID();
        assertNotNull(id);
        System.out.println(id);

        assertNotNull(baseResponseElement.getElement().getMeetingID());
        assertEquals(meetingDTO.getTitle(),baseResponseElement.getElement().getTitle());
        assertEquals(meetingDTO.getNote(),baseResponseElement.getElement().getNote());
        assertEquals(meetingDTO.getStartDate(),baseResponseElement.getElement().getStartDate());
        assertEquals(meetingDTO.getEndDate(),baseResponseElement.getElement().getEndDate());
        assertEquals(meetingDTO.getLink(),baseResponseElement.getElement().getLink());
        assertEquals(HttpStatus.CREATED,baseResponseElement.getHttpStatus());
    }

    @Test
    public void deleteMeeting() throws Exception {

        //test valido fino al 2025-04-16 05:00:00 per id1
        MockHttpServletResponse response = this.mock.perform(delete("/calendar/meeting/delete/1")
                .header("Authorization", "Bearer " + JWT)).andReturn().getResponse();
        BaseResponseElement<MeetingDTO> baseResponseElement = objectMapper.readValue(response.getContentAsString(),new TypeReference<BaseResponseElement<MeetingDTO>>() {});
        assertEquals(HttpStatus.OK,baseResponseElement.getHttpStatus());

        //Test per rilevare un eccezione
        //l id 1 non deve esistere
        assertThrows(SQLException.class, () ->
                meetingService.findById(baseResponseElement.getElement().getMeetingID()));
    }
    @Test
    public void updateMeeting() throws Exception{

        BaseResponseElement<Meeting> oldMeeting = meetingService.findById((long)2);

        MeetingDTO aggiornamento = new MeetingDTO();
        aggiornamento.setMeetingID((long)2);
        aggiornamento.setTitle("Aggiornamento meeting");
        aggiornamento.setNote("spostato");
        aggiornamento.setStartDate(LocalDateTime.of(2024,12,10,17,30));
        aggiornamento.setEndDate(LocalDateTime.of(2024,12,10,17,30));
        aggiornamento.setLink("www.aggiornamento.com");

        MockHttpServletResponse response = this.mock.perform(put("/calendar/meeting/update")
                .header("Authorization", "Bearer " + JWT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aggiornamento))).andReturn().getResponse();
        BaseResponseElement<MeetingDTO> baseResponseElement = objectMapper.readValue(response.getContentAsString(),new TypeReference<BaseResponseElement<MeetingDTO>>() {});

        assertEquals(oldMeeting.getElement().getMeetingID(),aggiornamento.getMeetingID());

        assertNotEquals(oldMeeting.getElement().getTitle(),aggiornamento.getTitle());

        assertEquals(HttpStatus.OK, baseResponseElement.getHttpStatus());
    }

    @Test
    public void cancelMeeting() throws Exception{

        MockHttpServletResponse response = this.mock.perform(put("/calendar/meeting/cancel/1")
                .header("Authorization", "Bearer " + JWT)).andReturn().getResponse();
        BaseResponseElement<MeetingDTO> baseResponseElement = objectMapper.readValue(response.getContentAsString(),new TypeReference<BaseResponseElement<MeetingDTO>>() {});
        assertEquals("*** This event was canceled on "+LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)+" *** Original note: filosofia del piccone",baseResponseElement.getElement().getNote());
    }
    @Test
    public void checkDate(){
        //Test check date, un evento passato non puo essere creato, eliminato o modificato
        assertThrows(Exception.class, () ->
                this.mock.perform(delete("/calendar/meeting/delete/3")
                        .header("Authorization", "Bearer " + JWT)).andReturn().getResponse());
    }
}
