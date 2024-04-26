package com.teamproject1.scuoledevelhope.classes.userMeeting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_meeting")
public class UserMeeting {
    @Id
    @Column(name ="id_user")
    private Long idUser;
    @Column(name ="id_meeting")
    private Long idMeeting;

    public UserMeeting() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(Long idMeeting) {
        this.idMeeting = idMeeting;
    }
}
