package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.MeetingResponse;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dto.MeetingDTO;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.mapper.MeetingMapper;
import com.teamproject1.scuoledevelhope.classes.user.repo.UserDao;
import com.teamproject1.scuoledevelhope.classes.userMeeting.UserMeeting;
import com.teamproject1.scuoledevelhope.classes.userMeeting.dto.UserMeetingDTO;
import com.teamproject1.scuoledevelhope.classes.userMeeting.repository.UserMeetingRepository;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.dto.UserRegistryDTO;
import com.teamproject1.scuoledevelhope.classes.userRegistry.mapper.UserRegistryMapper;
import com.teamproject1.scuoledevelhope.classes.userRegistry.repo.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {
    private final MeetingDAO meetingDAO;
    private final MeetingMapper mapper;
    private final UserMeetingRepository userMeetingRepository;
    private final UserRegistryDAO userRegistryDAO;
    private final UserRegistryMapper userRegistryMapper;
    private final UserDao userDao;

    public MeetingService(MeetingDAO meetingDAO, MeetingMapper mapper, UserMeetingRepository userMeetingRepository, UserRegistryDAO userRegistryDAO, UserRegistryMapper userRegistryMapper, UserDao userDao) {
        this.meetingDAO = meetingDAO;
        this.mapper = mapper;
        this.userMeetingRepository = userMeetingRepository;
        this.userRegistryDAO = userRegistryDAO;
        this.userRegistryMapper = userRegistryMapper;
        this.userDao = userDao;
    }

    //trova meeting by id
    public BaseResponseElement<Meeting> findById(Long id) {
        Optional<Meeting> results = meetingDAO.findById(id);
        if (results.isPresent()) {
            return new BaseResponseElement<>(results.get());
        }
        throw new SQLException("Meeting was not present");
    }

    //tutti i meeting di un user
    public BaseResponseList<MeetingDTO> allMeetingByUser(Long id, int page, int pageSize) {

        List<MeetingDTO> brlMeetingDTO = new ArrayList<>();
        Page<Meeting> meeting =  meetingDAO.allMeetingByUser(id, PageRequest.of(page, pageSize));

        for (Meeting m : meeting) {
            brlMeetingDTO.add(mapper.toMeetingDTO(m));
        }

        BaseResponseList<MeetingDTO> response = new BaseResponseList<>(brlMeetingDTO);
        response.setPage(meeting.getPageable().getPageNumber());
        response.setTotalPages(meeting.getTotalPages());
        response.setPageSize(meeting.getPageable().getPageSize());
        response.setTotalElements(meeting.getTotalElements());

        return response;
    }

    //tutti i meeting di un user in un intervallo di tempo
    public BaseResponseList<MeetingDTO> intervalGetById(Long id, LocalDate startDate, LocalDate endDate ,int page, int pageSize) {

        List<MeetingDTO> brlMeetingDTO = new ArrayList<>();
        Page<Meeting> meeting = meetingDAO.intervalGetByID(id, startDate, endDate, PageRequest.of(page, pageSize));

        for (Meeting m : meeting) {
            brlMeetingDTO.add(mapper.toMeetingDTO(m));
        }

        BaseResponseList<MeetingDTO> response = new BaseResponseList<>(brlMeetingDTO);
        response.setPage(meeting.getPageable().getPageNumber());
        response.setTotalPages(meeting.getTotalPages());
        response.setPageSize(meeting.getPageable().getPageSize());
        response.setTotalElements(meeting.getTotalElements());

        return response;

    }

    public BaseResponseElement<MeetingDTO> save(MeetingDTO meetingDTO) {

        meetingDTO.setMeetingID(null);
        checkData(meetingDTO);
        Meeting meeting = meetingDAO.save(mapper.toMeeting(meetingDTO));

        return new BaseResponseElement<MeetingDTO>(HttpStatus.CREATED, HttpStatus.CREATED.getReasonPhrase(), "Data saving successful", mapper.toMeetingDTO(meeting));
    }

    public BaseResponseElement<MeetingDTO> updateMeeting(MeetingDTO meetingDTO) {
        if (meetingDTO.getMeetingID() == null) {
            throw new SQLException("It is not possible to update the meeting without the ID");
        }
        checkData(meetingDTO);
        Meeting meeting = meetingDAO.save(mapper.toMeeting(meetingDTO));

        return new BaseResponseElement<>(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), "Data updated correctly", mapper.toMeetingDTO(meeting));
    }

    public BaseResponseElement<MeetingDTO> deleteMeeting(Long id) {

        MeetingDTO temp = new MeetingDTO();
        temp = mapper.toMeetingDTO(findById(id).getElement());
        checkData(temp);
        meetingDAO.deleteById(id);
        return new BaseResponseElement<>(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), "Meetings deleted", temp);
    }

    public MeetingDTO checkData(MeetingDTO meeting) {

        LocalDateTime start_date = meeting.getStartDate();
        LocalDateTime end_date = meeting.getEndDate();

        if (start_date.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("You cannot insert , update , cancel meeting into the past");
        }

        if (end_date.isBefore(start_date)) {
            throw new IllegalArgumentException("You mixed up the date");
        }
        return meeting;
    }

    public BaseResponseElement<MeetingDTO> cancelMeeting(Long id) {

        MeetingDTO temp = mapper.toMeetingDTO(findById(id).getElement());
        checkData(temp);
        temp.setNote("*** This event was canceled on " + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES) + " *** Original note: " + temp.getNote());
        temp.setLink("*** Link deleted ***");
        updateMeeting(temp);

        return new BaseResponseElement<>(temp);
    }

    //prossimo meeting di un user (entro 7 gg)
    public BaseResponseElement<MeetingDTO> nextMeetingById(Long id) {
        Meeting meeting = new Meeting();
        meeting = meetingDAO.nextMeetingById(id, LocalDate.now(), LocalDate.now().plusDays(7));
        if (meeting == null) {
            return new BaseResponseElement<>(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), "No meetings in the next 7 days", null);
        }
        return new BaseResponseElement<>(mapper.toMeetingDTO(meeting));
    }

    public BaseResponseElement<MeetingResponse> addParticipants(UserMeetingDTO participants) {

        MeetingResponse meetingResponse = new MeetingResponse();
        //setta il meeting nella risposta
        meetingResponse.setMeetingDTO(mapper.toMeetingDTO(findById(participants.getIdMeeting()).getElement()));

        //salva i partecipanti nella many to many
        for (Long usDTO : participants.getParticipantsId()) {
            UserMeeting userMeeting = new UserMeeting();
            userMeeting.setIdMeeting((participants.getIdMeeting()));
            userMeeting.setIdUser(usDTO);
            userMeetingRepository.save(userMeeting);
        }

        //sezione partecipanti
        List<UserRegistryDTO> userRegistryDTO = new ArrayList<>();
        List<UserRegistry> userRegistry = new ArrayList<>();
        userRegistry = userRegistryDAO.allUserByMeeting(participants.getIdMeeting());
        //conversione a userRegistryDTO
        for (UserRegistry ur : userRegistry) {
            userRegistryDTO.add(userRegistryMapper.toUserRegistryDTO(ur));
        }
        //aggiunge i partecipanti
        meetingResponse.setParticipants(userRegistryDTO);
        //ritorna la risposta completa

        return new BaseResponseElement<>(meetingResponse);
    }

    public BaseResponseElement<MeetingResponse> removeUserFromMeeting(UserMeetingDTO usDTO) {

        //controllo su presenza meeting
        if (meetingDAO.findById(usDTO.getIdMeeting()).isEmpty()) {
            throw new RuntimeException("This meeting does not exist");
        }
        for (Long userRemove : usDTO.getParticipantsId()) {
            //controllo se esiste l user
            if (userDao.findById(userRemove).isPresent()) {
                //rimuove utente e meeting dalla many to many
                userMeetingRepository.delete(new UserMeeting(userRemove, usDTO.getIdMeeting()));
            }
        }
        MeetingResponse meetingResponse = new MeetingResponse();
        meetingResponse.setMeetingDTO(mapper.toMeetingDTO(findById(usDTO.getIdMeeting()).getElement()));

        List<UserRegistryDTO> userRegistryDTO = new ArrayList<>();
        for (UserRegistry userRegistry : userRegistryDAO.allUserByMeeting(usDTO.getIdMeeting())) {
            userRegistryDTO.add(userRegistryMapper.toUserRegistryDTO(userRegistry));
        }

        meetingResponse.setParticipants(userRegistryDTO);
        return new BaseResponseElement<>(meetingResponse);

    }


}
