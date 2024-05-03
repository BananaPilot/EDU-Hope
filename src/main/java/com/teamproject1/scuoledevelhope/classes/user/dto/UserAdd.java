package com.teamproject1.scuoledevelhope.classes.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserAdd {
    @NotBlank(message = "username can't be blank")
    private String username;
    @NotBlank(message = "password can't be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;
    @NotBlank(message = "name can't be blank")
    private String name;
    @NotBlank(message = "surname can't be blank")
    private String surname;
    @NotBlank(message = "email can't be blank")
    private String email;
    @NotBlank(message = "phone number can't be blank")
    @Pattern(regexp = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[7-90]|36[680]|33[3-90]|32[89])\\d{7}$")
    private String phoneNumber;

    public UserAdd(String username, String password, String name, String surname, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserAdd() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final class UserAddBuilder {
        private @NotBlank(message = "username can't be blank") String username;
        private @NotBlank(message = "password can't be blank") String password;
        private @NotBlank(message = "name can't be blank") String name;
        private @NotBlank(message = "surname can't be blank") String surname;
        private @NotBlank(message = "email can't be blank") String email;
        private @NotBlank(message = "phone number can't be blank") String phoneNumber;

        private UserAddBuilder() {
        }

        public static UserAddBuilder anUserAdd() {
            return new UserAddBuilder();
        }

        public UserAddBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserAddBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserAddBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserAddBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserAddBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserAddBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserAdd build() {
            UserAdd userAdd = new UserAdd();
            userAdd.email = this.email;
            userAdd.password = this.password;
            userAdd.username = this.username;
            userAdd.surname = this.surname;
            userAdd.phoneNumber = this.phoneNumber;
            userAdd.name = this.name;
            return userAdd;
        }
    }
}
