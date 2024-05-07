package com.teamproject1.scuoledevelhope.classes.role.dto;


import com.teamproject1.scuoledevelhope.classes.role.Role;

public class RoleUsername {
    private String username;
    private Role.RoleEnum roleEnum;

    public RoleUsername(String username, Role.RoleEnum roleEnum) {
        this.username = username;
        this.roleEnum = roleEnum;
    }

    public RoleUsername() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role.RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(Role.RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }


    public static final class RoleUsernameBuilder {
        private String username;
        private Role.RoleEnum roleEnum;

        private RoleUsernameBuilder() {
        }

        public static RoleUsernameBuilder aRoleUsername() {
            return new RoleUsernameBuilder();
        }

        public RoleUsernameBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public RoleUsernameBuilder withRoleEnum(Role.RoleEnum roleEnum) {
            this.roleEnum = roleEnum;
            return this;
        }

        public RoleUsername build() {
            RoleUsername roleUsername = new RoleUsername();
            roleUsername.setUsername(username);
            roleUsername.setRoleEnum(roleEnum);
            return roleUsername;
        }
    }
}
