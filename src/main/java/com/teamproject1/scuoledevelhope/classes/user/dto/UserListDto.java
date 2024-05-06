package com.teamproject1.scuoledevelhope.classes.user.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserListDto extends Pagination {

    private List<UserDto> users;

    public UserListDto() {}

    public List<UserDto> getUsers() {
        return users;
    }

    public static final class UserListDtoBuilder {
        private List<UserDto> users;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private UserListDtoBuilder() {
        }

        public static UserListDtoBuilder anUserListDto() {
            return new UserListDtoBuilder();
        }

        public UserListDtoBuilder withUsers(List<UserDto> users) {
            this.users = users;
            return this;
        }

        public UserListDtoBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public UserListDtoBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public UserListDtoBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public UserListDtoBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public UserListDtoBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public UserListDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public UserListDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public UserListDto build() {
            UserListDto userListDto = new UserListDto();
            userListDto.setPage(page);
            userListDto.setPageSize(pageSize);
            userListDto.setTotalElements(totalElements);
            userListDto.setTotalPages(totalPages);
            userListDto.setHttpStatus(httpStatus);
            userListDto.setMessage(message);
            userListDto.setDescription(description);
            userListDto.users = this.users;
            return userListDto;
        }
    }
}
