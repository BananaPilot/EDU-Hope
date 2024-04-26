package com.teamproject1.scuoledevelhope.classes.userMeeting;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(UserMeeting.class)
@Table(name="user_meeting")
public class UserMeeting {
    @Id
    @Column(name ="id_user")
    private Long idUser;
    @Id
    @Column(name ="id_meeting")
    private Long idMeeting;

    public UserMeeting() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMeeting that = (UserMeeting) o;
        return Objects.equals(idUser, that.idUser) && Objects.equals(idMeeting, that.idMeeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idMeeting);
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
