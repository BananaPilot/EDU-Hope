package com.teamproject1.scuoledevelhope.classes.user_meeting;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@IdClass(UserMeeting.class)
@Table(name = "user_meeting")
public class UserMeeting {

    @Id
    @Column(name = "id_user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long idUser;

    @Id
    @Column(name = "id_meeting")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long idMeeting;

    public UserMeeting() {
    }

    public UserMeeting(Long idUser, Long idMeeting) {
        this.idUser = idUser;
        this.idMeeting = idMeeting;
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
