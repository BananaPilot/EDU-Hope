package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.classes.student.dto.StudentDto;
import com.teamproject1.scuoledevelhope.classes.vote.dto.VoteDto;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RegisterDtoWhitLists extends Pagination{
    private RegisterDto registerDto;
    private List<StudentDto> students;
    private List<VoteDto> votes;

    public RegisterDto getRegisterDto() {
        return registerDto;
    }

    public void setRegisterDto(RegisterDto registerDto) {
        this.registerDto = registerDto;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
        this.votes = votes;

    }


    public static final class RegisterDtoWhitListsBuilder {
        private RegisterDto registerDto;
        private List<StudentDto> students;
        private List<VoteDto> votes;
        private HttpStatus httpStatus;
        private String message;
        private String description;
        private int page;
        private int pageSize;
        private long totalElements;
        private int totalPages;

        private RegisterDtoWhitListsBuilder() {
        }

        public static RegisterDtoWhitListsBuilder aRegisterDtoWhitLists() {
            return new RegisterDtoWhitListsBuilder();
        }

        public RegisterDtoWhitListsBuilder withRegisterDto(RegisterDto registerDto) {
            this.registerDto = registerDto;
            return this;
        }

        public RegisterDtoWhitListsBuilder withStudents(List<StudentDto> students) {
            this.students = students;
            return this;
        }

        public RegisterDtoWhitListsBuilder withVotes(List<VoteDto> votes) {
            this.votes = votes;
            return this;
        }

        public RegisterDtoWhitListsBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public RegisterDtoWhitListsBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public RegisterDtoWhitListsBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RegisterDtoWhitListsBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public RegisterDtoWhitListsBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public RegisterDtoWhitListsBuilder withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public RegisterDtoWhitListsBuilder withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public RegisterDtoWhitLists build() {
            RegisterDtoWhitLists registerDtoWhitLists = new RegisterDtoWhitLists();
            registerDtoWhitLists.setRegisterDto(registerDto);
            registerDtoWhitLists.setStudents(students);
            registerDtoWhitLists.setVotes(votes);
            registerDtoWhitLists.setHttpStatus(httpStatus);
            registerDtoWhitLists.setMessage(message);
            registerDtoWhitLists.setDescription(description);
            registerDtoWhitLists.setPage(page);
            registerDtoWhitLists.setPageSize(pageSize);
            registerDtoWhitLists.setTotalElements(totalElements);
            registerDtoWhitLists.setTotalPages(totalPages);
            return registerDtoWhitLists;
        }
    }
}