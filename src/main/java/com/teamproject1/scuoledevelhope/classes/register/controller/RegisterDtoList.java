package com.teamproject1.scuoledevelhope.classes.register.controller;

import com.teamproject1.scuoledevelhope.classes.register.dto.RegisterDTO;
import com.teamproject1.scuoledevelhope.types.dtos.Pagination;

import java.util.List;

public class RegisterDtoList extends Pagination {

    private List<RegisterDTO> registerDtoList;

    public RegisterDtoList(List<RegisterDTO> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }

    public RegisterDtoList() {
    }

    public List<RegisterDTO> getRegisterDtoList() {
        return registerDtoList;
    }

    public void setRegisterDtoList(List<RegisterDTO> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }

    public static final class RegisterDtoListBuilder {
        private List<RegisterDTO> registerDtoList;

        private RegisterDtoListBuilder() {
        }

        public static RegisterDtoListBuilder aRegisterDtoList() {
            return new RegisterDtoListBuilder();
        }

        public RegisterDtoListBuilder withRegisterDtoList(List<RegisterDTO> registerDtoList) {
            this.registerDtoList = registerDtoList;
            return this;
        }

        public RegisterDtoList build() {

            return new RegisterDtoList(this.registerDtoList);
        }
    }
}
