package com.teamproject1.scuoledevelhope.classes.userRegistry.dto;

import org.springframework.stereotype.Component;

@Component
public class UrDtoNameSurname {
    private String name;
    private String surname;

    public UrDtoNameSurname() {
    }

    @Override
    public String toString() {
        return "UserRegistryDTONameSurname{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
