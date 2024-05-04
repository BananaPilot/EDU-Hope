package com.teamproject1.scuoledevelhope.classes.user.dto;


public class UserDto {

    private Long id;

    private String username;

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
