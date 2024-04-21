package com.teamproject1.scuoledevelhope.classes.userRegistry.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRegistryDTO {


    private String name;
    private String surname;
    private String email;
    private String telephone;

    public UserRegistryDTO() {
    }

    @Override
    public String toString() {
        return "PartecipanteDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
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

    public String getTelephone() {
        return telephone;
    }

}
