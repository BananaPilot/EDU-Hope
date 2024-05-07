package com.teamproject1.scuoledevelhope.classes.register.dto;

import com.teamproject1.scuoledevelhope.types.dtos.Pagination;

import java.util.List;

public class RegisterDtoListWithStudent extends Pagination {

    private List<RegisterDtoWithStudent> registerDtoList;

    public RegisterDtoListWithStudent(List<RegisterDtoWithStudent> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }

    public RegisterDtoListWithStudent() {
    }

    public List<RegisterDtoWithStudent> getRegisterDtoList() {
        return registerDtoList;
    }

    public void setRegisterDtoList(List<RegisterDtoWithStudent> registerDtoList) {
        this.registerDtoList = registerDtoList;
    }

    public static final class RegisterDtoListBuilder {
        private List<RegisterDtoWithStudent> registerDtoList;

        private RegisterDtoListBuilder() {
        }

        public static RegisterDtoListBuilder aRegisterDtoList() {
            return new RegisterDtoListBuilder();
        }

        public RegisterDtoListBuilder withRegisterDtoList(List<RegisterDtoWithStudent> registerDtoList) {
            this.registerDtoList = registerDtoList;
            return this;
        }

        public RegisterDtoListWithStudent build() {

            return new RegisterDtoListWithStudent(this.registerDtoList);
        }
    }
}
