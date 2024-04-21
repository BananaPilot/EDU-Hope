package com.teamproject1.scuoledevelhope.classes.calendar.meeting.service;

import com.teamproject1.scuoledevelhope.classes.calendar.meeting.Meeting;
import com.teamproject1.scuoledevelhope.classes.calendar.meeting.dao.MeetingDAO;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryDAO.UserRegistryDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MeetingService {

    MeetingDAO meetingDAO;
    UserRegistryDAO urDAO;

    public MeetingService(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

                        //----------- STUDENTE----------//
    public BaseResponseList<Meeting> allByStudentId(Long id) {
        return new BaseResponseList<>(meetingDAO.allByStudentId(id));
    }

    public BaseResponseList<Meeting> intervalStudentId(Long idStudent ,LocalDate startDate , LocalDate endDate){
        return new BaseResponseList<>(meetingDAO.intervalStudentId(idStudent ,startDate,endDate));
    }

    public List<UserRegistry> allStudentsByMeeting(Long iDmeeting){
        return urDAO.allStudentsByMeeting(iDmeeting);
    }
                        //----------- END STUDENTE----------//

                        //----------- TUTOR ----------//
    public BaseResponseList<Meeting> allByTutorId(Long id) {
        return new BaseResponseList<>(meetingDAO.allByTutorId(id));
    }

    public BaseResponseList<Meeting> intervalTutorId(Long idTutor , LocalDate startDate, LocalDate endDate){
        return new BaseResponseList<>(meetingDAO.intervalTutorId(idTutor,startDate,endDate));
    }

                        //----------- END TUTOR ----------//

                        //----------- COORDINATOR ----------//
    public BaseResponseList<Meeting> allByCoordinatorId(Long id) {
        return new BaseResponseList<>(meetingDAO.allByCoordinatorId(id));
    }

    public BaseResponseList<Meeting> intervalCoordinatorId(Long idCoordinator, LocalDate startDate , LocalDate endDate){
        return new BaseResponseList<>(meetingDAO.intervalCoordinatorId(idCoordinator,startDate,endDate));
    }

                     //----------- END COORDINATOR ----------//

    public BaseResponseElement<Meeting> save(Meeting meeting) {
        return new BaseResponseElement<Meeting>(meetingDAO.save(meeting));
    }

}
