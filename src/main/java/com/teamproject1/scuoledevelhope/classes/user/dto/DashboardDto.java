package com.teamproject1.scuoledevelhope.classes.user.dto;

import com.teamproject1.scuoledevelhope.classes.role.dto.RoleDashboard;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;

public class DashboardDto {

    private String username;
    private String password;
    private RoleDashboard role;
    private UserRegistry userRegistry;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RoleDashboard getRole() {
        return role;
    }

    public UserRegistry getUserRegistry() {
        return userRegistry;
    }

    public DashboardDto(String username, String password, RoleDashboard role, UserRegistry userRegistry) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.userRegistry = userRegistry;
    }

    public DashboardDto() {
    }

    public static final class DashboardDtoBuilder {
        private String username;
        private String password;
        private RoleDashboard role;
        private UserRegistry userRegistry;

        private DashboardDtoBuilder() {
        }

        public DashboardDtoBuilder map(User user) {
            return DashboardDtoBuilder.aDashboardDto()
                    .withPassword(user.getPassword())
                    .withUsername(user.getUsername())
                    .withUserRegistry(user.getUserRegistry());
        }

        public static DashboardDtoBuilder aDashboardDto() {
            return new DashboardDtoBuilder();
        }

        public DashboardDtoBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public DashboardDtoBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public DashboardDtoBuilder withRole(RoleDashboard role) {
            this.role = role;
            return this;
        }

        public DashboardDtoBuilder withUserRegistry(UserRegistry userRegistry) {
            this.userRegistry = userRegistry;
            return this;
        }

        public DashboardDto build() {
            DashboardDto dashboardDto = new DashboardDto();
            dashboardDto.userRegistry = this.userRegistry;
            dashboardDto.role = this.role;
            dashboardDto.username = this.username;
            dashboardDto.password = this.password;
            return dashboardDto;
        }
    }
}
