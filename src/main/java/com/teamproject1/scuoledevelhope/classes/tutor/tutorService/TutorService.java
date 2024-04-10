package com.teamproject1.scuoledevelhope.classes.tutor.tutorService;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import com.teamproject1.scuoledevelhope.classes.tutor.Tutor;
import com.teamproject1.scuoledevelhope.classes.tutor.tutorDAO.TutorDAO;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TutorService {
    @Autowired
    TutorDAO tutorDAO;

    public BaseResponseList<Tutor> getAll() {
        return new BaseResponseList<>(tutorDAO.findAll());

    }

    public BaseResponseElement<com.teamproject1.scuoledevelhope.classes.user.User> getByUsername(String username) {


        @Entity
        @Table(name = "tutor")
        public class Tutor {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;

            private String username;

            private String password;

            @ManyToMany
            private Set<Role> roles;
        }


        return null;
    }
