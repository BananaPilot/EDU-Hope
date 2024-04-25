package com.teamproject1.scuoledevelhope.classes.userRegistry.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRegistryDTO {


    private String name;
    private String surname;
    private String email;

    public UserRegistryDTO() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
